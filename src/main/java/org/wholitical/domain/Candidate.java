package org.wholitical.domain;

import lombok.Data;

/**
 *
 */
@Data
public class Candidate {

    private String office;
    private String active_through;
    private String candidate_status;
    private String party;
    private String district;
    private String party_full;
    private String[] election_years;
    private String name;
    private String office_full;
    private String state;
    private String[] election_districts;
    private String candidate_id;
    private String district_number;
    private String incumbent_challenge_full;
    private String load_date;
    private String[] cycles;
    private String incumbent_challenge;

}
