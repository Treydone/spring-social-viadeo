package org.springframework.social.viadeo.api;

import org.springframework.social.ApiBinding;
import org.springframework.social.viadeo.api.impl.ViadeoTemplate;


/**
 * Interface specifying a basic set of operations for interacting with Viadeo.
 * Implemented by {@link ViadeoTemplate}.
 */
public interface Viadeo extends ApiBinding {

	UserOperations userOperations();

	JobOperations jobOperations();
}
