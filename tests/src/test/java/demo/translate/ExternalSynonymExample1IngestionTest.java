package demo.translate;

import com.regnosys.ingest.test.framework.ingestor.ExpectationUtil;
import com.regnosys.ingest.test.framework.ingestor.IngestionTest;
import com.regnosys.ingest.test.framework.ingestor.IngestionTestUtil;
import com.regnosys.ingest.test.framework.ingestor.service.IngestionFactory;
import com.regnosys.ingest.test.framework.ingestor.service.IngestionService;
import com.regnosys.model.ModelRuntimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.provider.Arguments;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

//@org.junit.jupiter.api.Disabled
public class ExternalSynonymExample1IngestionTest extends IngestionTest<demo.translate.external_synonym.example_1.Root> {

    private static final String SAMPLE_FILES_DIR = "cdm-sample-files/external-synonym/example-1";
    private static final String INSTANCE_NAME = "target/EXTERNAL_SYNONYM_EXAMPLE_1";

    private static IngestionService ingestionService;

    @BeforeAll
    static void setup() {
        writeActualExpectations = ExpectationUtil.WRITE_EXPECTATIONS;

        ClassLoader cl = ExternalSynonymExample1IngestionTest.class.getClassLoader();
        Collection<URL> ingestURLs = List.of(
                Objects.requireNonNull(cl.getResource("ingestions/external-synonym-example-1-ingestions.json")));
        ModelRuntimeModule runtimeModule = new ModelRuntimeModule();
        initialiseIngestionFactory(INSTANCE_NAME, ingestURLs, runtimeModule, new ArrayList<>(IngestionTestUtil.getPostProcessors(runtimeModule)));
        IngestionFactory factory = IngestionFactory.getInstance(INSTANCE_NAME);
        ingestionService = factory.getService("EXTERNAL_SYNONYM_EXAMPLE_1");
    }

    @Override
    protected Class<demo.translate.external_synonym.example_1.Root> getClazz() {
        return demo.translate.external_synonym.example_1.Root.class;
    }

    @Override
    protected IngestionService ingestionService() {
        return ingestionService;
    }


    @SuppressWarnings("unused")//used by the junit parameterized test
    private static Stream<Arguments> fpMLFiles() {
        return readExpectationsFromPath(SAMPLE_FILES_DIR);
    }

}
