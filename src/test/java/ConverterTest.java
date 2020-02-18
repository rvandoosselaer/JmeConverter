import com.rvandoosselaer.jmeconverter.Converter;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author: rvandoosselaer
 */
public class ConverterTest {

    public static final String MODEL = "dabel/scene.gltf";

    public static void main(String[] args) {
        new ConverterTest().run();
    }

    public void run() {
        Path modelPath = null;
        try {
            modelPath = Paths.get(ConverterTest.class.getClassLoader().getResource(MODEL).toURI());
        } catch (URISyntaxException e) {
            System.err.println(e.getMessage() + " - " + e);
        }

        Converter converter = new Converter();
        converter.convert(modelPath);
    }
}
