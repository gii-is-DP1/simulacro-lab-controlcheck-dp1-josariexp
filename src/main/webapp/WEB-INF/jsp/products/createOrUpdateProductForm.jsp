<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>



<petclinic:layout pageName="Products">
	<jsp:body>
		<form:form modelAttribute="product" class="form-horizontal">
            <div class="form-group has-feedback">
            	<input type="hidden" name="id" value="${product.id}"/>
            	<petclinic:inputField label="Name" name="name"/>
            	<petclinic:inputField label="Price" name="price"/>
            	<div class="control-group">
            	    <petclinic:selectField label="Type " name="productType" names="${productType}" size="5"/>
                </div>
			</div>
			<div class="form-group">
				<button class="btn btn-default" type="submit">Add Product</button>
			</div>
		
		</form:form>
	</jsp:body>
</petclinic:layout>