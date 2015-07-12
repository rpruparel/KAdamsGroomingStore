package Grooming.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-01-04T16:25:07")
@StaticMetamodel(Order.class)
public class Order_ { 

    public static volatile SingularAttribute<Order, Integer> userID;
    public static volatile SingularAttribute<Order, Boolean> paid;
    public static volatile SingularAttribute<Order, Float> totalCost;
    public static volatile SingularAttribute<Order, Float> taxRate;
    public static volatile SingularAttribute<Order, Integer> orderNumber;
    public static volatile SingularAttribute<Order, Date> date;

}