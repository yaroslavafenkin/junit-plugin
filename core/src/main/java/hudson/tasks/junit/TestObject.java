package hudson.tasks.junit;

import hudson.model.AbstractBuild;
import hudson.model.ModelObject;
import hudson.Util;

import java.io.Serializable;

/**
 * Base class for all test result objects.
 *
 * @author Kohsuke Kawaguchi
 */
public abstract class TestObject implements ModelObject, Serializable {
    public abstract AbstractBuild<?,?> getOwner();

    /**
     * Gets the counter part of this {@link TestObject} in the previous run.
     *
     * @return null
     *      if no such counter part exists.
     */
    public abstract TestObject getPreviousResult();

    /**
     * Time took to run this test. In seconds.
     */
    public abstract float getDuration();

    /**
     * Returns the string representation of the {@link #getDuration()},
     * in a human readable format.
     */
    public String getDurationString() {
        return Util.getTimeSpanString((long)(getDuration()*1000));
    }

    /**
     * Replaces URL-unasfe characters.
     */
    protected static String safe(String s) {
        return s.replace('/','_').replace(':','_');
    }

    private static final long serialVersionUID = 1L;
}
