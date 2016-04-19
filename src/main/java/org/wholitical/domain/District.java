package org.wholitical.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Lee on 4/18/16.
 */
@Data
@Entity
public class District {

    @Id
    private Integer zipcode;
    private String state;
    private Integer district;

}
