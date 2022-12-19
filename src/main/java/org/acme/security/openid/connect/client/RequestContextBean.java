package org.acme.security.openid.connect.client;

import javax.enterprise.context.RequestScoped;
import java.io.Serializable;
import java.util.HashMap;


@RequestScoped
public class RequestContextBean extends HashMap<String, Object> implements Serializable {
    static final long serialVersionUID = -63300801164598784L;
}
