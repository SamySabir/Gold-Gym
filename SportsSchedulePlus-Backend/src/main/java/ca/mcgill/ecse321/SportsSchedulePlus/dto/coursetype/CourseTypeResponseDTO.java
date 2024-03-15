package ca.mcgill.ecse321.SportsSchedulePlus.dto.coursetype;

import ca.mcgill.ecse321.SportsSchedulePlus.model.CourseType;

public class CourseTypeResponseDTO {
    private Integer id;
    private String description;
    private boolean approvedByOwner;
    private float price;

    public CourseTypeResponseDTO(Integer id, String description, boolean approvedByOwner, float price) {
        this.id = id;
        this.description = description;
        this.approvedByOwner = approvedByOwner;
        this.price = price;
    }

    // Constructor that takes a CourseType as input
    public CourseTypeResponseDTO(CourseType courseType) {
        this.id = courseType.getId();
        this.description = courseType.getDescription();
        this.approvedByOwner = courseType.isApprovedByOwner();
        this.price = courseType.getPrice();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isApprovedByOwner() {
        return approvedByOwner;
    }

    public void setApprovedByOwner(boolean approvedByOwner) {
        this.approvedByOwner = approvedByOwner;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}