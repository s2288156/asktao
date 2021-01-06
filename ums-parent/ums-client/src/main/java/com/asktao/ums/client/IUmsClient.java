package com.asktao.ums.client;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author wcy
 */
@FeignClient(value = "ums")
public interface IUmsClient {

}
