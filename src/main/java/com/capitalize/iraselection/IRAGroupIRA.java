package com.capitalize.iraselection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "iragroupira")
public class IRAGroupIRA implements Serializable {
    @Id
    @Column(name = "groupid", insertable = false, updatable = false)
    private Long groupId;

    @Id
    @Column(name = "iraid", insertable = false, updatable = false)
    private Long iraId;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getIraId() {
        return iraId;
    }

    public void setIraId(Long iraId) {
        this.iraId = iraId;
    }
}
