package com.me.mapper;

import com.me.dto.BaseUserDetails;
import com.me.dto.LoginHistoryDTO;
import com.me.dto.ResourceDTO;
import com.me.dto.RoleDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Me on 2018/8/18.
 */
public interface SecurityMapper {

    BaseUserDetails getUserByUsername(String username);

    ResourceDTO getHomePageByUsername(String username);

    List<RoleDTO> listRoleByUsername(String username);

    List<ResourceDTO> listResourceByUsername(String username);

    void saveLoginHistory(LoginHistoryDTO loginHistoryDTO);
}
