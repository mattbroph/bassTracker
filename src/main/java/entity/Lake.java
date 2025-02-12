package entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

/**
 * The type Lake.
 */
public class Lake {

    /** The unique Lake ID */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int lakeId;

    /** The name of the lake */
    @Column(name = "LakeName")
    private String lakeName;

    /** The user's id (TODO - id will be hardcoded for now) */
    @Column(name = "UserID")
    private int userId;



    /**
     * Instantiates a new Lake.
     *
     * @param lakeId   the lake id
     * @param lakeName the lake name
     * @param userId   the user id
     */
    public Lake(int lakeId, String lakeName, int userId) {
        this.lakeId = lakeId;
        this.lakeName = lakeName;
        this.userId = userId;
    }


    /**
     * Gets lake id.
     *
     * @return the lake id
     */
    public int getLakeId() {
        return lakeId;
    }

    /**
     * Sets lake id.
     *
     * @param lakeId the lake id
     */
    public void setLakeId(int lakeId) {
        this.lakeId = lakeId;
    }

    /**
     * Gets lake name.
     *
     * @return the lake name
     */
    public String getLakeName() {
        return lakeName;
    }

    /**
     * Sets lake name.
     *
     * @param lakeName the lake name
     */
    public void setLakeName(String lakeName) {
        this.lakeName = lakeName;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Gets all the instance variables for debugging
     * @return the lake instance variables
     */
    @Override
    public String toString() {
        return "Lake{" +
                "lakeId=" + lakeId +
                ", lakeName='" + lakeName + '\'' +
                ", userId=" + userId +
                '}';
    }
}





