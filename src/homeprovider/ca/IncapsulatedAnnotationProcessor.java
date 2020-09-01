package homeprovider.ca;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic.Kind;

@SupportedAnnotationTypes(value = { "homeprovider.ca.Incapsulated" })
public class IncapsulatedAnnotationProcessor extends AbstractProcessor {

	private Messager messager;

	@Override
	public void init(ProcessingEnvironment processingEnv) {
		super.init(processingEnv);
		messager = processingEnv.getMessager();
	}

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

		for (TypeElement te : annotations) {
			Set<? extends Element> annotatedElements = roundEnv.getElementsAnnotatedWith(te);
			for (Element e : annotatedElements) {
				messager.printMessage(Kind.ERROR, "Incapsulated processor found and runinng", e);
			}
		}

		return true;
	}

}
