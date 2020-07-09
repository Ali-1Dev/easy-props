/*
 * The MIT License
 *
 *   Copyright (c) 2020, Mahmoud Ben Hassine (mahmoud.benhassine@icloud.com)
 *
 *   Permission is hereby granted, free of charge, to any person obtaining a copy
 *   of this software and associated documentation files (the "Software"), to deal
 *   in the Software without restriction, including without limitation the rights
 *   to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *   copies of the Software, and to permit persons to whom the Software is
 *   furnished to do so, subject to the following conditions:
 *
 *   The above copyright notice and this permission notice shall be included in
 *   all copies or substantial portions of the Software.
 *
 *   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *   FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *   AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *   THE SOFTWARE.
 */
package org.jeasy.props.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation injects a header from a {@code META-INF/MANIFEST.MF} file in the annotated field.
 *
 * @author Mahmoud Ben Hassine (mahmoud.benhassine@icloud.com)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ManifestProperty {

    /**
     * The jar file name (in the classpath) containing the {@code META-INF/MANIFEST.MF} file.
     *
     * @return jar file name (in the classpath) containing {@code META-INF/MANIFEST.MF} file.
     */
    String jar();

    /**
     * The header name in the {@code META-INF/MANIFEST.MF} file.
     *
     * @return the header name in the {@code META-INF/MANIFEST.MF} file.
     */
    String header();

    /**
     * The default value to set in case the header does not exist or cannot be loaded.
     *
     * @return the default value to set
     */
    String defaultValue() default "";

    /**
     * Flag to fail the configuration process if the header is absent
     *
     * @return true if the configuration process should fail fast if the header is absent
     */
    boolean failFast() default false;

    /**
     * Injection order regarding other annotations.
     *
     * @return injection order regarding other annotations
     */
    int order() default 0;

}
