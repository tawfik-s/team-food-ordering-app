package com.fawry.foodorderingapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fawry.foodorderingapi.model.ItemOrderSummaryDto;
import lombok.*;

import javax.persistence.*;

import java.util.List;

@SqlResultSetMapping(
        name = "ItemOrderSummaryDto",
        classes = @ConstructorResult(
                targetClass = ItemOrderSummaryDto.class,
                columns = {
                        @ColumnResult(name = "item", type = String.class),
                        @ColumnResult(name = "quantity",type = Long.class),
                        @ColumnResult(name = "totalPrice",type = float.class)
                }
        )
)
@Entity(name = "orders")
@NamedNativeQuery(
        name = "filterNative",
        query = "SELECT food.name AS item, SUM(sub_order.quantity) AS quantity, " +
                " SUM(sub_order.sub_order_price) AS totalPrice " +
                " FROM sub_order " +
                " INNER JOIN food ON sub_order.food_id = food.id " +
                " INNER JOIN orders ON sub_order.order_id = orders.id " +
                " WHERE orders.group_id like :groupId AND orders.status = 1 " +
                " GROUP BY food.name",
        resultSetMapping = "ItemOrderSummaryDto"
)
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<SubOrder> items;

    @JsonIgnore
    @ManyToOne
    private AppUser user;

    @JsonIgnore
    @ManyToOne
    private AppGroup group;

    @JsonIgnore
    private boolean status;

    private Long numOfItems;

    private float orderPrice;


}
