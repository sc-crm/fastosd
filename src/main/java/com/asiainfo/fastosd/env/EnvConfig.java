package com.asiainfo.fastosd.env;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Steven
 */
@Data
@Builder
public class EnvConfig {

	private String name;
	private boolean debug;
	private String externalApex;
	private String internalApex;
	private String scheme;

	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	private static Map<String, EnvConfig> map;

	static {
		map = new HashMap<>();

		// 开发环境
		EnvConfig envConfig = EnvConfig.builder().name(EnvConstant.ENV_DEV)
			.debug(true)
			.externalApex("crm-order-v1.local")
			.internalApex(EnvConstant.ENV_DEV)
			.scheme("http")
			.build();
		map.put(EnvConstant.ENV_DEV, envConfig);

		// 测试环境
		envConfig = EnvConfig.builder().name(EnvConstant.ENV_TEST)
			.debug(true)
			.externalApex("crm-order-v1.local")
			.internalApex(EnvConstant.ENV_DEV)
			.scheme("http")
			.build();
		map.put(EnvConstant.ENV_TEST, envConfig);

		// 用户验证环境，又称在线测试环境
		envConfig = EnvConfig.builder().name(EnvConstant.ENV_UAT)
			.debug(true)
			.externalApex("crm-order-uat.local")
			.internalApex(EnvConstant.ENV_UAT)
			.scheme("http")
			.build();
		map.put(EnvConstant.ENV_UAT, envConfig);

		// 生产环境
		envConfig = EnvConfig.builder().name(EnvConstant.ENV_PROD)
			.debug(false)
			.externalApex("order.crm.com")
			.internalApex(EnvConstant.ENV_PROD)
			.scheme("https")
			.build();
		map.put(EnvConstant.ENV_PROD, envConfig);
	}

	public static EnvConfig getEnvConfig(String env) {
		EnvConfig envConfig = map.get(env);
		if (null == envConfig) {
			envConfig = map.get(EnvConstant.ENV_DEV);
		}
		return envConfig;
	}
}
