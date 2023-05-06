package com.app.api.health.dto;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data @Builder
public class HealthCheckResponseDto {

	@Schema(description = "서버 health 상태", example = "ok", required = true)
	private String health;

	@Schema(description = "현재 실행 중인 profile", example = "[dev]", required = true)
	private List<String> activeProfiles;
}
