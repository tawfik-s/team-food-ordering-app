package com.fawry.foodorderingapi.service.impl;

import com.fawry.foodorderingapi.entity.*;
import com.fawry.foodorderingapi.exception.RecordNotFoundException;
import com.fawry.foodorderingapi.model.FoodItemDto;
import com.fawry.foodorderingapi.model.OrderDto;
import com.fawry.foodorderingapi.model.ItemOrderSummaryDto;
import com.fawry.foodorderingapi.model.UserOrderSummaryDto;
import com.fawry.foodorderingapi.repository.AppGroupRepo;
import com.fawry.foodorderingapi.repository.FoodRepo;
import com.fawry.foodorderingapi.repository.OrderRepo;
import com.fawry.foodorderingapi.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService implements com.fawry.foodorderingapi.service.OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private FoodRepo foodRepo;
    @Autowired
    private FoodService foodService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private AppGroupRepo groupRepo;



    @Transactional
    public Long createOrder(OrderDto orderDto , Long groupId) {
        Order order = new Order();
        order.setNumOfItems((long) orderDto.getFood().size());
        order.setItems(new ArrayList<>());
        AppUser currentUser=userService.getCurrentUser();
        AppGroup currentGroup=groupRepo.findById(groupId).orElseThrow(()->new RecordNotFoundException("Group Not Found"));
        float count = 0;


        for(FoodItemDto foodItemDto : orderDto.getFood()){
            Food foodItem = foodService.getFoodById(foodItemDto.getItemId());
            order.getItems().add(new SubOrder(foodItemDto.getQuantity(),foodItem,order,foodItemDto.getComment(),foodItemDto.getQuantity()*foodItem.getPrice()));
            foodRepo.saveAndFlush(foodItem);
        }
        for (SubOrder subOrder:order.getItems()){
            count+=subOrder.getSubOrderPrice();

        }

            order.setOrderPrice(count);
            order.setUser(currentUser);
            order.setGroup(currentGroup);
            if(currentUser.getOwnedGroups().contains(currentGroup)){
            order.setStatus(true);
            }else{
                order.setStatus(false);
            }
            orderRepo.saveAndFlush(order);
            return (order.getId());
    }



    @Override
    @Transactional
    public Long createGroupOrder(Long groupId){
        AppUser currentUser=userService.getCurrentUser();
        AppGroup currentGroup = groupRepo.findById(groupId).orElseThrow(()->new RecordNotFoundException("Group Not Found"));
        if(currentUser.getOwnedGroups().contains(currentGroup)){
            currentGroup.getUsers().stream()
                    .forEach(user->user.getOrders().stream()
                            .forEach(order ->{ if (!order.isStatus())order.setStatus(true);}));
        }
        return currentGroup.getId();
    }



    public void deleteOrder(Long id){

        orderRepo.deleteById(id);

    }


    public List<Order> getAllOrdersForCurrentUser(){

        AppUser currentUser=userService.getCurrentUser();
        return currentUser.getOrders();
    }


    public List<Order> getAllGroupOrders(Long groupId){

        return orderRepo.findByGroupId(groupId);

    }


    public List<ItemOrderSummaryDto>getOrderSummaryPerItem(Long groupId){
            return orderRepo.filterNative(groupId);
    }


    @Transactional
    public List<UserOrderSummaryDto>getOrderSummaryPerUser(Long groupId){
        UserOrderSummaryDto userOrderSummary=new UserOrderSummaryDto();
        List<UserOrderSummaryDto>listOfUserOrderSummary=new ArrayList<>();
        AppUser currentUser=userService.getCurrentUser();
        AppGroup currentGroup = groupRepo.findById(groupId)
                .orElseThrow(()->new RecordNotFoundException("Group Not Found"));

        for (AppUser user:currentGroup.getUsers()){
            //TODO Add only active orders for each user to order summary list
            userOrderSummary.setUsername(user.getName());
            userOrderSummary.setOrders(user.getOrders().stream()
                    .filter(order -> order.isStatus())
                    .collect(Collectors.toList()));
            listOfUserOrderSummary.add(userOrderSummary);
        }
        //TODO Add group owner's orders to the list
        UserOrderSummaryDto groupOwnerOrderSummary=new UserOrderSummaryDto();
        groupOwnerOrderSummary.setUsername(currentUser.getName());
        groupOwnerOrderSummary.setOrders(currentUser.getOrders());

        listOfUserOrderSummary.add(groupOwnerOrderSummary);


        return listOfUserOrderSummary;
    }

}
