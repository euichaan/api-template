package com.app.api.health.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class HealthCheckResponseDto {

	private String health;
	private List<String> activeProfiles;
}
