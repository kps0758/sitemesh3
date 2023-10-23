/*
 *    Copyright 2009-2023 SiteMesh authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.sitemesh.builder;

import org.sitemesh.offline.SiteMeshOffline;

/**
 * Convenient API for building the a {@link org.sitemesh.offline.SiteMeshOffline}.
 *
 * <p>This follows the API builder pattern - each method returns a reference to the original builder
 * so they can be chained together. When configured, call the {@link #create()} method which will
 * return the final immutable {@link org.sitemesh.offline.SiteMeshOffline}.</p>
 *
 * <p>At the very least, <b>sourceDirectory</b> and <b>destinationDirectory must be set</b> before
 * calling {@link #create()}, otherwise an {@link IllegalStateException} will be thrown.</p>
 *
 * <h2>Examples</h2>
 *
 * <pre>
 * // Simplest example...
 * SiteMeshOffline siteMeshOffline = new SiteMeshOfflineBuilder()
 *     .setDirectory("src/html")
 *     .setDestinationDirectory("dest/html")
 *     .addDecoratorPath("/*", "/decorator.html")
 *     .create();
 *
 * // A few more options (shows applying multiple decorators to a single page)...
 * SiteMeshOffline siteMeshOffline = new SiteMeshOfflineBuilder()
 *     .setDirectory(new File("src/html"))
 *     .setDestinationDirectory(new File("dest/html"))
 *     .addDecoratorPaths("/*", "/decorators/main-layout.html", "/decorators-common-style.html")
 *     .addDecoratorPaths("/admin/*", "/decorators/admin-layout.html", "/decorators-common-style.html")
 *     .addTagRuleBundle(new MyLinkRewriterBundle())
 *     .create();
 *
 * // If you want to get a bit crazy and totally customize SiteMesh...
 * SiteMeshOffline siteMeshOffline = new SiteMeshOfflineBuilder()
 *     .setDirectory(new MyDirectoryThatLoadsFromDatabase())
 *     .setDestinationDirectory(new InMemoryDirectory())
 *     .setCustomContentProcessor(new MySvgContentProcessor())
 *     .setCustomDecoratorSelector(new MyDatabaseDrivenDecoratorSelector())
 *     .create();
 * </pre>
 *
 * <h3>Custom implementations (advanced)</h3>
 *
 * <p>This is only for advanced users who need to change the behavior of the builder...</p>
 *
 * <p>If you ever find the need to subclass SiteMeshOfflineBuilder (e.g. to add more convenience
 * methods, to change the implementation returned, or add new functionality), it is instead recommended
 * that you extends {@link BaseSiteMeshOfflineBuilder}. This way, the generic type signature can
 * be altered.</p>
 *
 * @author Joe Walnes
 */

public final class SiteMeshOfflineBuilder
        extends BaseSiteMeshOfflineBuilder<SiteMeshOfflineBuilder> {

    /**
     * Create the SiteMeshOfflineGenerator.
     *
     * @throws IllegalStateException unless both the source and destionation
     *                               directories have been set.
     */
    public SiteMeshOffline create() throws IllegalStateException {
        return new SiteMeshOffline(
                getContentProcessor(),
                getDecoratorSelector(),
                getSourceDirectory(),
                getDestinationDirectory());
    }

}
