package com.mattbroph.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;


/**
 * Represents the BassGoals set by the user
 */
@Entity
@Table(name = "bassgoal")
public class BassGoal {

    /** The unique BassGoal ID */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "GoalID")
    private int id;

    /** The user to display on the dashboard */
    @ManyToOne
    @JoinColumn(name = "UserID")
    @NotNull(message = "User must be provided")
    private User user;

    /** The year to display on the dashboard */
    @Column(name = "GoalYear")
    @Min(value = 1900, message = "Goal year must be a valid year")
    @Max(value = 2100, message = "Goal year must be a valid year")
    private int goalYear;

    /** The user's bass goal count */
    @Column(name = "GoalCount")
    @Min(value = 0, message = "Goal count must be between 0 and 1000")
    @Max(value = 1000, message = "Goal count must be between 0 and 1000")
    private int goalCount;

    /**
     * Instantiates a new Bass goal.
     */
    public BassGoal() {
    }

    /**
     * Instantiates a new Bass goal.
     *
     * @param user      the user
     * @param goalYear  the goal year
     * @param goalCount the goal count
     */
    public BassGoal(User user, int goalYear, int goalCount) {
        this();
        this.user = user;
        this.goalYear = goalYear;
        this.goalCount = goalCount;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets goal year.
     *
     * @return the goal year
     */
    public int getGoalYear() {
        return goalYear;
    }

    /**
     * Sets goal year.
     *
     * @param goalYear the goal year
     */
    public void setGoalYear(int goalYear) {
        this.goalYear = goalYear;
    }

    /**
     * Gets goal count.
     *
     * @return the goal count
     */
    public int getGoalCount() {
        return goalCount;
    }

    /**
     * Sets goal count.
     *
     * @param goalCount the goal count
     */
    public void setGoalCount(int goalCount) {
        this.goalCount = goalCount;
    }

    @Override
    public String toString() {
        return "BassGoal{" +
                "id=" + id +
                ", goalYear=" + goalYear +
                ", goalCount=" + goalCount +
                '}';
    }
}
