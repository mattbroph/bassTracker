package com.mattbroph.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a fishing method
 */
@Entity(name = "Method")
@Table(name = "method")
public class Method {

    /** The unique Method ID */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name = "MethodID")
    private int id;

    /** The method type */
    @Column(name = "MethodName")
    private String methodName;

    /** The list of journals that reference the method */
    @OneToMany(mappedBy = "method", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Journal> journals = new ArrayList<>();

    /**
     * Empty constructor for instantiating a method object
     */
    public Method() {
    }

    /**
     * Instantiates a new Method.
     *
     * @param methodName the method type
     */
    public Method(String methodName) {
        this();
        this.methodName = methodName;
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
     * Gets method type.
     *
     * @return the method type
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * Sets method type.
     *
     * @param methodName the method type
     */
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    /**
     * Gets journals.
     *
     * @return the journals
     */
    public List<Journal> getJournals() {
        return journals;
    }

    /**
     * Sets journals.
     *
     * @param journals the journals
     */
    public void setJournals(List<Journal> journals) {
        this.journals = journals;
    }

    @Override
    public String toString() {
        return "Method{" +
                "id=" + id +
                ", methodName='" + methodName + '\'' +
                '}';
    }
}
