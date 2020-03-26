package ch.cyberduck.core.sds;

/*
 * Copyright (c) 2002-2017 iterate GmbH. All rights reserved.
 * https://cyberduck.io/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

import ch.cyberduck.core.AttributedList;
import ch.cyberduck.core.Cache;
import ch.cyberduck.core.Filter;
import ch.cyberduck.core.ListProgressListener;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.PathAttributes;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.features.Search;
import ch.cyberduck.core.sds.io.swagger.client.ApiException;
import ch.cyberduck.core.sds.io.swagger.client.api.NodesApi;
import ch.cyberduck.core.sds.io.swagger.client.model.Node;
import ch.cyberduck.core.sds.io.swagger.client.model.NodeList;
import ch.cyberduck.core.unicode.NFCNormalizer;

import org.apache.commons.lang3.StringUtils;

import java.util.EnumSet;

public class SDSSearchFeature implements Search {

    private final SDSSession session;
    private final SDSNodeIdProvider nodeid;

    public SDSSearchFeature(final SDSSession session, final SDSNodeIdProvider nodeid) {
        this.session = session;
        this.nodeid = nodeid;
    }

    @Override
    public AttributedList<Path> search(final Path workdir, final Filter<Path> regex, final ListProgressListener listener) throws BackgroundException {
        try {
            final AttributedList<Path> result = new AttributedList<>();
            final NodeList list = new NodesApi(session.getClient()).searchFsNodes(
                String.format("*%s*", new NFCNormalizer().normalize(regex.toPattern().pattern())), StringUtils.EMPTY, null,
                -1, null, null, null, Long.valueOf(nodeid.getFileid(workdir, listener)), null);
            final SDSAttributesFinderFeature feature = new SDSAttributesFinderFeature(session, nodeid);
            for(Node node : list.getItems()) {
                final PathAttributes attributes = feature.toAttributes(node);
                final EnumSet<Path.Type> type;
                switch(node.getType()) {
                    case ROOM:
                        type = EnumSet.of(Path.Type.directory, Path.Type.volume);
                        break;
                    case FOLDER:
                        type = EnumSet.of(Path.Type.directory);
                        break;
                    default:
                        type = EnumSet.of(Path.Type.file);
                        break;
                }
                result.add(new Path(String.format("%s%s", node.getParentPath(), node.getName()), type, attributes));
            }
            return result;
        }
        catch(ApiException e) {
            throw new SDSExceptionMappingService().map("Failure to read attributes of {0}", e, workdir);
        }
    }

    @Override
    public boolean isRecursive() {
        return true;
    }

    @Override
    public Search withCache(final Cache<Path> cache) {
        return this;
    }
}
