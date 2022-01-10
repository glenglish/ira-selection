package com.capitalize.iraselection;

import javax.persistence.*;
import java.util.List;

@Entity
public class IRAGroup {
    @Id
    @SequenceGenerator(name = "iragroup_seq", sequenceName = "iragroup_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "iragroup_seq")
    private Long id;

    String groupName;

    @ManyToMany
    @JoinTable(
            name = "iragroupira",
            joinColumns = @JoinColumn(name = "groupid"),
            inverseJoinColumns = @JoinColumn(name = "iraid")
    )
    List<IRA> iras;

    public List<IRA> getIRAs() {
        return this.iras;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
