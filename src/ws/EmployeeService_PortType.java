/**
 * EmployeeService_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ws;

public interface EmployeeService_PortType extends java.rmi.Remote {
    public ws.Employee getDetails(java.lang.String empid) throws java.rmi.RemoteException;
    public ws.Employee[] getEmployees() throws java.rmi.RemoteException;
}
