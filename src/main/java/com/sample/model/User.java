package com.sample.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String idxId;
    private String bedRockId;
}
