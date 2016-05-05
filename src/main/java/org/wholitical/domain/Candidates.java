package org.wholitical.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 *
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Candidates {

    private List<Candidate> results;

}
