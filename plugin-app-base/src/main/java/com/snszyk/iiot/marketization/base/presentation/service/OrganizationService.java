package com.snszyk.iiot.marketization.base.presentation.service;

import com.snszyk.iiot.marketization.base.presentation.model.Organization;
import com.snszyk.iiot.marketization.base.presentation.model.OrganizationQuery;
import com.snszyk.iiot.marketization.base.presentation.model.TreeNodeDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrganizationService {
    @Autowired
    private OrganizationQuery organizationQuery;

    public List<TreeNodeDto> queryOrganizationTree(String id) {
        List<TreeNodeDto> treeNodeDtoList = new ArrayList<>(0);
        List<Organization> organizations = organizationQuery.findAll();
        Map<String, List<Organization>> orgParentMap = organizations.stream().collect(Collectors.groupingBy(Organization::getParentId));
        List<Organization> organizationList = new ArrayList<>();
        List<Organization> emptyList = Collections.emptyList();
        if (StringUtils.isBlank(id)) {
            organizationList.addAll(orgParentMap.getOrDefault("", emptyList));
        } else {
            organizationList.addAll(orgParentMap.getOrDefault(id, emptyList));
        }
        if (!CollectionUtils.isEmpty(organizationList)) {
            dealTree(treeNodeDtoList, organizationList, orgParentMap);
        }
        return treeNodeDtoList;
    }

    private void dealTree(List<TreeNodeDto> treeNodeDtoList, List<Organization> organizationList, Map<String, List<Organization>> orgParentMap) {
        organizationList.forEach(organization -> {
            List<TreeNodeDto> children = new ArrayList<>(0);
            TreeNodeDto treeNodeDto = new TreeNodeDto(organization, children);
            treeNodeDtoList.add(treeNodeDto);

            List<Organization> childOrgList = orgParentMap.get(organization.getId());
            if (!CollectionUtils.isEmpty(childOrgList)) {
                dealTree(children, childOrgList, orgParentMap);
            }
        });
    }
}
