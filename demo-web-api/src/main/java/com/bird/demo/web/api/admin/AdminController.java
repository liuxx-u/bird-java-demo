package com.bird.demo.web.api.admin;

import com.bird.core.utils.DozerHelper;
import com.bird.web.sso.AuthorizeController;

import javax.inject.Inject;

/**
 * @author liuxx
 * @date 2018/6/21
 */
public abstract class AdminController extends AuthorizeController {

    @Inject
    protected DozerHelper dozer;
}
