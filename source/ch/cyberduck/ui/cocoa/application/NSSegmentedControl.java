package ch.cyberduck.ui.cocoa.application;

/*
 * Copyright (c) 2002-2009 David Kocher. All rights reserved.
 *
 * http://cyberduck.ch/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * Bug fixes, suggestions and comments should be sent to:
 * dkocher@cyberduck.ch
 */

import org.rococoa.cocoa.CGFloat;

/// <i>native declaration : :26</i>
public abstract class NSSegmentedControl implements NSControl {
    private static final _Class CLASS = org.rococoa.Rococoa.createClass("NSSegmentedControl", _Class.class);

    @Override
    public CGFloat frameRotation() {
        throw new UnsupportedOperationException();
    }

    public interface _Class extends org.rococoa.NSClass {
        NSSegmentedControl alloc();
    }

    /**
     * Original signature : <code>void setSegmentCount(NSInteger)</code><br>
     * <i>native declaration : :34</i>
     */
    public abstract void setSegmentCount(int count);

    /**
     * Original signature : <code>NSInteger segmentCount()</code><br>
     * <i>native declaration : :35</i>
     */
    public abstract int segmentCount();

    /**
     * Original signature : <code>public abstract void setSelectedSegment(NSInteger)</code><br>
     * <i>native declaration : :37</i>
     */
    public abstract void setSelectedSegment(int selectedSegment);

    /**
     * Original signature : <code>NSInteger selectedSegment()</code><br>
     * <i>native declaration : :38</i>
     */
    public abstract int selectedSegment();

    /**
     * Original signature : <code>BOOL selectSegmentWithTag(NSInteger)</code><br>
     * <i>native declaration : :41</i>
     */
    public abstract boolean selectSegmentWithTag(int tag);

    /**
     * Original signature : <code>public abstract void setWidth(CGFloat, NSInteger)</code><br>
     * <i>native declaration : :44</i>
     */
    public abstract void setWidth_forSegment(float width, int segment);

    /**
     * Original signature : <code>CGFloat widthForSegment(NSInteger)</code><br>
     * <i>native declaration : :45</i>
     */
    public abstract float widthForSegment(int segment);

    /**
     * Original signature : <code>public abstract void setImage(NSImage*, NSInteger)</code><br>
     * <i>native declaration : :47</i>
     */
    public abstract void setImage_forSegment(NSImage image, int segment);

    public void setImage(NSImage image, int segment) {
        this.setImage_forSegment(image, segment);
    }

    /**
     * Original signature : <code>NSImage* imageForSegment(NSInteger)</code><br>
     * <i>native declaration : :48</i>
     */
    public abstract NSImage imageForSegment(int segment);
    /**
     * <i>native declaration : :52</i><br>
     * Conversion Error : /// Original signature : <code>public abstract void setImageScaling(null, NSInteger)</code><br>
     * - (public abstract void)setImageScaling:(null)scaling forSegment:(NSInteger)segment; (Argument scaling cannot be converted)
     */
    /**
     * Original signature : <code>imageScalingForSegment(NSInteger)</code><br>
     * <i>native declaration : :53</i>
     */
    public abstract com.sun.jna.Pointer imageScalingForSegment(int segment);

    /**
     * Original signature : <code>public abstract void setLabel(NSString*, NSInteger)</code><br>
     * <i>native declaration : :57</i>
     */
    public abstract void setLabel_forSegment(String label, int segment);

    /**
     * Original signature : <code>NSString* labelForSegment(NSInteger)</code><br>
     * <i>native declaration : :58</i>
     */
    public abstract String labelForSegment(int segment);

    /**
     * Original signature : <code>public abstract void setMenu(NSMenu*, NSInteger)</code><br>
     * <i>native declaration : :60</i>
     */
    public abstract void setMenu_forSegment(NSMenu menu, int segment);

    /**
     * Original signature : <code>NSMenu* menuForSegment(NSInteger)</code><br>
     * <i>native declaration : :61</i>
     */
    public abstract NSMenu menuForSegment(int segment);

    /**
     * Original signature : <code>public abstract void setSelected(BOOL, NSInteger)</code><br>
     * <i>native declaration : :63</i>
     */
    public abstract void setSelected_forSegment(boolean selected, int segment);

    /**
     * Original signature : <code>BOOL isSelectedForSegment(NSInteger)</code><br>
     * <i>native declaration : :64</i>
     */
    public abstract boolean isSelectedForSegment(int segment);

    public void setEnabled(boolean enabled, int segment) {
        this.setEnabled_forSegment(enabled, segment);
    }

    /**
     * Original signature : <code>public abstract void setEnabled(BOOL, NSInteger)</code><br>
     * <i>native declaration : :66</i>
     */
    public abstract void setEnabled_forSegment(boolean enabled, int segment);

    /**
     * Original signature : <code>BOOL isEnabledForSegment(NSInteger)</code><br>
     * <i>native declaration : :67</i>
     */
    public abstract boolean isEnabledForSegment(int segment);

    /**
     * Original signature : <code>public abstract void setSegmentStyle(NSSegmentStyle)</code><br>
     * <i>native declaration : :70</i>
     */
    public abstract void setSegmentStyle(int segmentStyle);

    /**
     * Original signature : <code>NSSegmentStyle segmentStyle()</code><br>
     * <i>native declaration : :71</i>
     */
    public abstract int segmentStyle();
}
