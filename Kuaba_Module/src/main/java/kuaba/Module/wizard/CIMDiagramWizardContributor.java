package kuaba.Module.wizard;

import org.modelio.api.modelio.diagram.IDiagramService;
import org.modelio.api.modelio.diagram.style.IStyleHandle;
import org.modelio.api.modelio.model.IMetamodelExtensions;
import org.modelio.api.modelio.model.IModelingSession;
import org.modelio.api.modelio.model.ITransaction;
import org.modelio.api.module.context.IModuleContext;
import org.modelio.api.module.contributor.ElementDescriptor;
import org.modelio.api.module.contributor.diagramcreation.AbstractDiagramWizardContributor;
import org.modelio.metamodel.diagrams.AbstractDiagram;
import org.modelio.metamodel.diagrams.ClassDiagram;
import org.modelio.metamodel.uml.infrastructure.ModelElement;
import org.modelio.metamodel.uml.infrastructure.Stereotype;
import org.modelio.vcore.smkernel.mapi.MClass;
import org.modelio.vcore.smkernel.mapi.MMetamodel;
import org.modelio.vcore.smkernel.mapi.MStatus;

import kuaba.Module.api.IKuabaPeerModule;
import kuaba.Module.diagram.CIMDiagram;

public class CIMDiagramWizardContributor extends AbstractDiagramWizardContributor {

	@Override
    public AbstractDiagram actionPerformed(ModelElement diagramOwner, String diagramName, String diagramDescription) {
        IModuleContext context = getModule().getModuleContext();
        IModelingSession session = context.getModelingSession();
        IDiagramService diagramService = context.getModelioServices().getDiagramService();
        
        try (ITransaction transaction = session.createTransaction("");) {
            IStyleHandle style = diagramService.getStyle(getStyle());
            CIMDiagram cim = new CIMDiagram(diagramOwner, style, context);
            
            cim.getElement().setName(diagramName);
        	context.getModelioServices().getEditionService().openEditor(cim.getElement());
            transaction.commit();
            return cim.getElement();
            
        } catch (Exception e) {
        	context.getLogService().error(e);
        }
        return null;
    }

    @Override
    public ElementDescriptor getCreatedElementType() {
        IModuleContext context = getModule().getModuleContext();
        MMetamodel metamodel = context.getModelioServices().getMetamodelService().getMetamodel();
    	MClass mClass = metamodel.getMClass(ClassDiagram.class);
        IMetamodelExtensions extensions = context.getModelingSession().getMetamodelExtensions();
        Stereotype stereotype = extensions.getStereotype(IKuabaPeerModule.MODULE_NAME, "CIMDiagram", mClass);
        return stereotype != null ? new ElementDescriptor(mClass, stereotype) : null; 
    }

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
    protected boolean checkCanCreateIn(ModelElement owner) {
        MStatus status = owner.getStatus();
        return status.isModifiable() || (owner.getMClass().isCmsNode() && status.isCmsManaged());
    }
	
	protected String getStyle() {
        return getParameters().get("style");
    }
}