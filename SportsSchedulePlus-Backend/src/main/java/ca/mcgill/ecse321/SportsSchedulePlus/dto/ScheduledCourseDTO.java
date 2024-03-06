package ca.mcgill.ecse321.SportsSchedulePlus.dto;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.33.0.6934.a386b0a58 modeling language!*/

import ca.mcgill.ecse321.SportsSchedulePlus.model.ScheduledCourse;

import java.sql.Date;
import java.sql.Time;
import java.util.*;

// line 41 "model.ump"
// line 110 "model.ump"
public class ScheduledCourseDTO
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ScheduledCourseDTO Attributes
  private int id;
  private Date date;
  private Time startTime;
  private Time endTime;
  private String location;

  //ScheduledCourseDTO Associations
  private CourseTypeDTO courseType;
  private List<PaymentDTO> coursePayments;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ScheduledCourseDTO(int aId, Date aDate, Time aStartTime, Time aEndTime, String aLocation, CourseTypeDTO aCourseType)
  {
    id = aId;
    date = aDate;
    startTime = aStartTime;
    endTime = aEndTime;
    location = aLocation;
    boolean didAddCourseType = setCourseType(aCourseType);
    if (!didAddCourseType)
    {
      throw new RuntimeException("Unable to create scheduledCourse due to courseType. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    coursePayments = new ArrayList<PaymentDTO>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(int aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean setDate(Date aDate)
  {
    boolean wasSet = false;
    date = aDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setStartTime(Time aStartTime)
  {
    boolean wasSet = false;
    startTime = aStartTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setEndTime(Time aEndTime)
  {
    boolean wasSet = false;
    endTime = aEndTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setLocation(String aLocation)
  {
    boolean wasSet = false;
    location = aLocation;
    wasSet = true;
    return wasSet;
  }

  public int getId()
  {
    return id;
  }

  public Date getDate()
  {
    return date;
  }

  public Time getStartTime()
  {
    return startTime;
  }

  public Time getEndTime()
  {
    return endTime;
  }

  public String getLocation()
  {
    return location;
  }
  /* Code from template association_GetOne */
  public CourseTypeDTO getCourseType()
  {
    return courseType;
  }
  /* Code from template association_GetMany */
  public PaymentDTO getCoursePayment(int index)
  {
    PaymentDTO aCoursePayment = coursePayments.get(index);
    return aCoursePayment;
  }

  public List<PaymentDTO> getCoursePayments()
  {
    List<PaymentDTO> newCoursePayments = Collections.unmodifiableList(coursePayments);
    return newCoursePayments;
  }

  public int numberOfCoursePayments()
  {
    int number = coursePayments.size();
    return number;
  }

  public boolean hasCoursePayments()
  {
    boolean has = coursePayments.size() > 0;
    return has;
  }

  public int indexOfCoursePayment(PaymentDTO aCoursePayment)
  {
    int index = coursePayments.indexOf(aCoursePayment);
    return index;
  }
  /* Code from template association_SetOneToMany */
  public boolean setCourseType(CourseTypeDTO aCourseType)
  {
    boolean wasSet = false;
    if (aCourseType == null)
    {
      return wasSet;
    }

    CourseTypeDTO existingCourseType = courseType;
    courseType = aCourseType;
    if (existingCourseType != null && !existingCourseType.equals(aCourseType))
    {
      existingCourseType.removeScheduledCourse(this);
    }
    courseType.addScheduledCourse(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCoursePayments()
  {
    return 0;
  }
  /* Code from template association_AddUnidirectionalMany */
  public boolean addCoursePayment(PaymentDTO aCoursePayment)
  {
    boolean wasAdded = false;
    if (coursePayments.contains(aCoursePayment)) { return false; }
    coursePayments.add(aCoursePayment);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCoursePayment(PaymentDTO aCoursePayment)
  {
    boolean wasRemoved = false;
    if (coursePayments.contains(aCoursePayment))
    {
      coursePayments.remove(aCoursePayment);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addCoursePaymentAt(PaymentDTO aCoursePayment, int index)
  {  
    boolean wasAdded = false;
    if(addCoursePayment(aCoursePayment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCoursePayments()) { index = numberOfCoursePayments() - 1; }
      coursePayments.remove(aCoursePayment);
      coursePayments.add(index, aCoursePayment);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCoursePaymentAt(PaymentDTO aCoursePayment, int index)
  {
    boolean wasAdded = false;
    if(coursePayments.contains(aCoursePayment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCoursePayments()) { index = numberOfCoursePayments() - 1; }
      coursePayments.remove(aCoursePayment);
      coursePayments.add(index, aCoursePayment);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCoursePaymentAt(aCoursePayment, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    CourseTypeDTO placeholderCourseType = courseType;
    this.courseType = null;
    if(placeholderCourseType != null)
    {
      placeholderCourseType.removeScheduledCourse(this);
    }
    coursePayments.clear();
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "location" + ":" + getLocation()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "date" + "=" + (getDate() != null ? !getDate().equals(this)  ? getDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "startTime" + "=" + (getStartTime() != null ? !getStartTime().equals(this)  ? getStartTime().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "endTime" + "=" + (getEndTime() != null ? !getEndTime().equals(this)  ? getEndTime().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "courseType = "+(getCourseType()!=null?Integer.toHexString(System.identityHashCode(getCourseType())):"null");
  }
}