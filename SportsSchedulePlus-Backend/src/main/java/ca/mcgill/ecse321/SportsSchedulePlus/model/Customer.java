package ca.mcgill.ecse321.SportsSchedulePlus.model;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/


import java.util.*;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

// line 25 "model.ump"
// line 100 "model.ump"
@Entity
public class Customer extends PersonRole
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Customer Associations
  @OneToMany
  private List<Payment> customerPayments;
  @OneToMany
  private List<ScheduledCourse> coursesRegistered;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Customer(){
    
  }
  public Customer(int aId)
  {
    super(aId);
    customerPayments = new ArrayList<Payment>();
    coursesRegistered = new ArrayList<ScheduledCourse>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public Payment getCustomerPayment(int index)
  {
    Payment aCustomerPayment = customerPayments.get(index);
    return aCustomerPayment;
  }

  public List<Payment> getCustomerPayments()
  {
    List<Payment> newCustomerPayments = Collections.unmodifiableList(customerPayments);
    return newCustomerPayments;
  }

  public int numberOfCustomerPayments()
  {
    int number = customerPayments.size();
    return number;
  }

  public boolean hasCustomerPayments()
  {
    boolean has = customerPayments.size() > 0;
    return has;
  }

  public int indexOfCustomerPayment(Payment aCustomerPayment)
  {
    int index = customerPayments.indexOf(aCustomerPayment);
    return index;
  }
  /* Code from template association_GetMany */
  public ScheduledCourse getCoursesRegistered(int index)
  {
    ScheduledCourse aCoursesRegistered = coursesRegistered.get(index);
    return aCoursesRegistered;
  }

  public List<ScheduledCourse> getCoursesRegistered()
  {
    List<ScheduledCourse> newCoursesRegistered = Collections.unmodifiableList(coursesRegistered);
    return newCoursesRegistered;
  }

  public int numberOfCoursesRegistered()
  {
    int number = coursesRegistered.size();
    return number;
  }

  public boolean hasCoursesRegistered()
  {
    boolean has = coursesRegistered.size() > 0;
    return has;
  }

  public int indexOfCoursesRegistered(ScheduledCourse aCoursesRegistered)
  {
    int index = coursesRegistered.indexOf(aCoursesRegistered);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCustomerPayments()
  {
    return 0;
  }
  /* Code from template association_AddUnidirectionalMany */
  public boolean addCustomerPayment(Payment aCustomerPayment)
  {
    boolean wasAdded = false;
    if (customerPayments.contains(aCustomerPayment)) { return false; }
    customerPayments.add(aCustomerPayment);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCustomerPayment(Payment aCustomerPayment)
  {
    boolean wasRemoved = false;
    if (customerPayments.contains(aCustomerPayment))
    {
      customerPayments.remove(aCustomerPayment);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addCustomerPaymentAt(Payment aCustomerPayment, int index)
  {  
    boolean wasAdded = false;
    if(addCustomerPayment(aCustomerPayment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCustomerPayments()) { index = numberOfCustomerPayments() - 1; }
      customerPayments.remove(aCustomerPayment);
      customerPayments.add(index, aCustomerPayment);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCustomerPaymentAt(Payment aCustomerPayment, int index)
  {
    boolean wasAdded = false;
    if(customerPayments.contains(aCustomerPayment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCustomerPayments()) { index = numberOfCustomerPayments() - 1; }
      customerPayments.remove(aCustomerPayment);
      customerPayments.add(index, aCustomerPayment);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCustomerPaymentAt(aCustomerPayment, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCoursesRegistered()
  {
    return 0;
  }
  /* Code from template association_AddUnidirectionalMany */
  public boolean addCoursesRegistered(ScheduledCourse aCoursesRegistered)
  {
    boolean wasAdded = false;
    if (coursesRegistered.contains(aCoursesRegistered)) { return false; }
    coursesRegistered.add(aCoursesRegistered);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCoursesRegistered(ScheduledCourse aCoursesRegistered)
  {
    boolean wasRemoved = false;
    if (coursesRegistered.contains(aCoursesRegistered))
    {
      coursesRegistered.remove(aCoursesRegistered);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addCoursesRegisteredAt(ScheduledCourse aCoursesRegistered, int index)
  {  
    boolean wasAdded = false;
    if(addCoursesRegistered(aCoursesRegistered))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCoursesRegistered()) { index = numberOfCoursesRegistered() - 1; }
      coursesRegistered.remove(aCoursesRegistered);
      coursesRegistered.add(index, aCoursesRegistered);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCoursesRegisteredAt(ScheduledCourse aCoursesRegistered, int index)
  {
    boolean wasAdded = false;
    if(coursesRegistered.contains(aCoursesRegistered))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCoursesRegistered()) { index = numberOfCoursesRegistered() - 1; }
      coursesRegistered.remove(aCoursesRegistered);
      coursesRegistered.add(index, aCoursesRegistered);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCoursesRegisteredAt(aCoursesRegistered, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    customerPayments.clear();
    coursesRegistered.clear();
    super.delete();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Customer that = (Customer) o;
    return Objects.equals(getId(), that.getId()) &&
    Objects.equals(getCoursesRegistered(), that.getCoursesRegistered()) &&
    Objects.equals(getCustomerPayments(), that.getCustomerPayments());
  }

}
