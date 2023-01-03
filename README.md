# team-food-ordering-app

building a food ordering app that may be used in a company or by a group of people to collect an order to a restaurant

## Requirements

you would be responsible for building a food ordering app that may be used in a company or by a group of people to collect an order to a restaurant

the functions (stories) of the new app should be as follow:

1. create group (by group owner)
2. list groups
3. join group
4. approve join request
5. order food
6. view orders summary categorized per item
7. view orders summary categorized per user
8. finish (group owner)

Please have a discussion together about

1. How to build this app
2. Think with details about how to implement every feature (this may need to add more features)
3. Decide about the technology stack, db type, frameworks, libraries that may be used
4. Agree on a database design

### this repository contain code for backend at api folder

### to access angualar frontend repo this the link [project angular](https://github.com/emostafa866)

## project screen shots

### user sign up screen

![register screen](/images/sign-up.png)

### user login screen

![login screen](/images/login-screen.png)

### user add group screen

![add group screen](/images/create-group-page.png)

### list and request to join group screen

![list group screen](/images/groups-list.png)

### admin food order screen

![food order screen](/images/admin-order%20-bage.png)

### show groups order per item

![groups item](/images/show-group-items-perOrder.png)

### add restaurant screen

![add restaurant](/images/add-restaurant.png)

### add food to restaurant screen

![add food](/images/add-food-to-restaurant.png)

## database schema

```sql
create table food_order.app_user
(
    id       bigint       not null
        primary key,
    email    varchar(255) null,
    name     varchar(255) null,
    password varchar(255) null,
    phone    varchar(255) null
);

create table food_order.hibernate_sequence
(
    next_val bigint null
);

create table food_order.restaurant
(
    id    bigint       not null
        primary key,
    phone varchar(255) null,
    name  varchar(255) null
);

create table food_order.app_group
(
    id                               bigint       not null
        primary key,
    any_one_can_join_without_request varchar(255) null,
    group_is_finished                varchar(255) null,
    title                            varchar(255) null,
    restaurant_id                    bigint       null,
    constraint FK22on64c7jfj4sosyigwa51md2
        foreign key (restaurant_id) references food_order.restaurant (id)
);

create table food_order.app_group_users
(
    app_group_id bigint not null,
    users_id     bigint not null,
    constraint FK3r2mw1jtfxnbr33xn1k374khx
        foreign key (users_id) references food_order.app_user (id),
    constraint FKbjeic8ocmmvs75m0yjy05no21
        foreign key (app_group_id) references food_order.app_group (id)
);

create table food_order.app_group_users_request_to_join
(
    app_group_id             bigint not null,
    users_request_to_join_id bigint not null,
    constraint FKeds3vshd3eoini8vnla2jeu5h
        foreign key (users_request_to_join_id) references food_order.app_user (id),
    constraint FKmeqhnrjphklnajm7lulqay109
        foreign key (app_group_id) references food_order.app_group (id)
);

create table food_order.app_user_owned_groups
(
    app_user_id     bigint not null,
    owned_groups_id bigint not null,
    constraint UK_co4se68p6nnisfqtd1e6ulaei
        unique (owned_groups_id),
    constraint FK6pvu2ihqlc7cl6kokxbj0l15g
        foreign key (owned_groups_id) references food_order.app_group (id),
    constraint FKaiw6pjfxd03e8txusgoqxjxg8
        foreign key (app_user_id) references food_order.app_user (id)
);

create table food_order.food
(
    id            bigint       not null
        primary key,
    image         varchar(255) null,
    name          varchar(255) null,
    price         double       not null,
    restaurant_id bigint       null,
    constraint FKm9xrxt95wwp1r2s7andom1l1c
        foreign key (restaurant_id) references food_order.restaurant (id)
);

create table food_order.orders
(
    id           bigint not null
        primary key,
    num_of_items bigint null,
    order_price  float  not null,
    status       bit    not null,
    group_id     bigint null,
    user_id      bigint null,
    constraint FKosotb7rvgk4myda45ki0cf9j
        foreign key (user_id) references food_order.app_user (id),
    constraint FKpsn0quyo33c07kcphg5alxasn
        foreign key (group_id) references food_order.app_group (id)
);

create table food_order.app_group_order
(
    app_group_id bigint not null,
    order_id     bigint not null,
    constraint UK_s387318pkaa6xuna2bgi25mp
        unique (order_id),
    constraint FKafah9tqj6v5k2dwtli7gf9g1d
        foreign key (order_id) references food_order.orders (id),
    constraint FKor2yjd9m1b32dlp9q2umwcng6
        foreign key (app_group_id) references food_order.app_group (id)
);

create table food_order.restaurant_foods
(
    restaurant_id bigint not null,
    foods_id      bigint not null,
    constraint UK_jcui1ncguod9vfe1qbpksy46j
        unique (foods_id),
    constraint FK4dbvvswitmtp26c2n425c9d12
        foreign key (restaurant_id) references food_order.restaurant (id),
    constraint FK546hh7nv85x4dl0aefekixbm6
        foreign key (foods_id) references food_order.food (id)
);

create table food_order.sub_order
(
    id              bigint       not null
        primary key,
    comment         varchar(255) null,
    quantity        int          not null,
    sub_order_price float        not null,
    food_id         bigint       null,
    order_id        bigint       null,
    constraint FK34oe81qmdaivn69r6vhy7a21a
        foreign key (food_id) references food_order.food (id),
    constraint FK5orv6yl7xnpkdf4xxq6ewrl6s
        foreign key (order_id) references food_order.orders (id)
);



```
