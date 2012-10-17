package org.eclipse.viatra2.emf.incquery.base.test.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import school.School;
import school.SchoolPackage;

public class ResourceAccess {

	private static TransactionalEditingDomain transactionalEditingDomain;
	private static ResourceSet resourceSet = null;
	
	public static School getEObject() {
		return (School) getResource().getContents().get(0);
	}
	
	public static Resource getResource() {
		return getResourceSet().getResources().get(0);
	}
	
	public static ResourceSet getResourceSet() {
		if (resourceSet == null) {			
		    SchoolPackage.eINSTANCE.eClass();
		    Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		    Map<String, Object> m = reg.getExtensionToFactoryMap();
		    m.put("school", new XMIResourceFactoryImpl());
		    resourceSet = new ResourceSetImpl();
		    transactionalEditingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(resourceSet);
		    resourceSet.getResource(URI.createURI("model/BUTE.school"), true);
		}
		return resourceSet;
	}
	
	public static  List<EObject> getAllContents() {
		List<EObject> contents = new ArrayList<EObject>();
		TreeIterator<EObject> iterator = getEObject().eAllContents();
		
		while (iterator.hasNext()) {
			contents.add(iterator.next());
		}
		
		return contents;
	}
		
	public static TransactionalEditingDomain getTransactionalEditingDomain() {
		return transactionalEditingDomain;
	}
}
