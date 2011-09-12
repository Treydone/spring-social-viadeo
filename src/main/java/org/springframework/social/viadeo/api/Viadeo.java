package org.springframework.social.viadeo.api;

import org.springframework.social.ApiBinding;

/**
 * Interface specifying a basic set of operations for interacting with Viadeo.
 * Implemented by {@link FacebookTemplate}.
 * 
 * @author Vincent Devillers
 */
public interface Viadeo extends ApiBinding {

	UserOperations userOperations();

	JobOperations jobOperations();
}
