package hudson.plugins.rubymetricfu.dataset;

import hudson.model.Build;
import hudson.plugins.rubymetricfu.RubyMetricsBuildAction;
import hudson.plugins.rubymetricfu.dataset.FlayMetricDataSetBuilder;
import hudson.plugins.rubymetricfu.model.MetricFuResults;

import org.jfree.data.category.CategoryDataset;

import junit.framework.TestCase;
import test.java.hudson.plugins.rubymetricfu.dataset.AbstractMetricDataSetBuilderTest;
import static org.mockito.Mockito.*;

/**
 *
 * @author josephwilk
 */
public class FlayMetricDataSetBuilderTest extends AbstractMetricDataSetBuilderTest{

    public FlayMetricDataSetBuilder builder(){
        return new FlayMetricDataSetBuilder();
    }  

    public void testItShouldAddMetricsToDataSet() throws Exception {
        MetricFuResults results = new MetricFuResults();
        results.setFlayTotal("100.0");

        RubyMetricsBuildAction action = new RubyMetricsBuildAction(mockOwner, results);

        CategoryDataset data = builder().buildDataSet(action);

        assertEquals("Flay value was not stored",  (Float)data.getValue("Flay average", data.getColumnKey(0)), new Float(100.0));
    }

  
}
