# soapExample
Symple SOAP service

Веб сервис разворачивается на localhost согласно файлу настроек
```
server.port=8188
server.servlet.context-path=/soapexample
```  
На вход принимает запрос вида (POST):
```
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" 
xmlns:sch="http://www.soapexample.antony.glim/util">
	<soapenv:Header/>
    <soapenv:Body>
        <sch:getUsersListRequest> 
        	<sch:name>somename</sch:name>
        </sch:getUsersListRequest>
    </soapenv:Body>
</soapenv:Envelope>
```  
В ответ сервис отдаст список пользователей завернутых воо внешний класс вида:
```
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <ns2:getUsersListResponse xmlns:ns2="http://www.soapexample.antony.glim/util">
            <ns2:usersList>
                <ns2:users>
                    <ns2:name>Name 1</ns2:name>
                    <ns2:secondName>SecondName 1</ns2:secondName>
                    <ns2:phone>+7123456781</ns2:phone>
                    <ns2:address>Some Address 1</ns2:address>
                </ns2:users>
                <ns2:users>
                    <ns2:name>Name 2</ns2:name>
                    <ns2:secondName>SecondName 2</ns2:secondName>
                    <ns2:phone>+7123456782</ns2:phone>
                    <ns2:address>Some Address 2</ns2:address>
                </ns2:users>
                <ns2:users>
                    <ns2:name>Name 3</ns2:name>
                    <ns2:secondName>SecondName 3</ns2:secondName>
                    <ns2:phone>+7123456783</ns2:phone>
                    <ns2:address>Some Address 3</ns2:address>
                </ns2:users>
            </ns2:usersList>
        </ns2:getUsersListResponse>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```  

Классы в пакете utils генерируются автоматически при помощи jaxb2 плагина  
Адрес http://localhost:8188/soapexample/ws/users.wsdl вернет следующее:  
```
<wsdl:definitions xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" xmlns:sch="http://www.soapexample.antony.glim/util" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:tns="http://www.soapexample.antony.glim/util" targetNamespace="http://www.soapexample.antony.glim/util">
<wsdl:types>
	<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema" elementFormDefault="qualified" targetNamespace="http://www.soapexample.antony.glim/util">
		<xs:element name="getUsersListRequest">
			<xs:complexType>
				<xs:sequence>
					<xs:element name="name" type="xs:string"/>
				</xs:sequence>
			</xs:complexType>
		</xs:element>
		<xs:element name="getUsersListResponse">
			<xs:complexType>
				<xs:sequence>
					<xs:element name="usersList" type="tns:usersList"/>
				</xs:sequence>
			</xs:complexType>
		</xs:element>
		<xs:complexType name="user">
			<xs:sequence>
				<xs:element name="name" type="xs:string"/>
				<xs:element name="secondName" type="xs:string"/>
				<xs:element name="phone" type="xs:string"/>
				<xs:element name="address" type="xs:string"/>
			</xs:sequence>
		</xs:complexType>
		<xs:complexType name="usersList">
			<xs:sequence>
				<xs:element maxOccurs="unbounded" minOccurs="0" name="users" type="tns:user"/>
			</xs:sequence>
		</xs:complexType>
	</xs:schema>
</wsdl:types>
<wsdl:message name="getUsersListRequest">
	<wsdl:part element="tns:getUsersListRequest" name="getUsersListRequest"> </wsdl:part>
</wsdl:message>
<wsdl:message name="getUsersListResponse">
	<wsdl:part element="tns:getUsersListResponse" name="getUsersListResponse"> </wsdl:part>
</wsdl:message>
<wsdl:portType name="UsersPort">
	<wsdl:operation name="getUsersList">
		<wsdl:input message="tns:getUsersListRequest" name="getUsersListRequest"> </wsdl:input>
		<wsdl:output message="tns:getUsersListResponse" name="getUsersListResponse"> </wsdl:output>
	</wsdl:operation>
</wsdl:portType>
<wsdl:binding name="UsersPortSoap11" type="tns:UsersPort">
	<soap:binding style="document" transport="http://schemas.xmlsoap.org/soap/http"/>
	<wsdl:operation name="getUsersList">
		<soap:operation soapAction=""/>
		<wsdl:input name="getUsersListRequest">
			<soap:body use="literal"/>
		</wsdl:input>
		<wsdl:output name="getUsersListResponse">
			<soap:body use="literal"/>
		</wsdl:output>
	</wsdl:operation>
</wsdl:binding>
<wsdl:service name="UsersPortService">
	<wsdl:port binding="tns:UsersPortSoap11" name="UsersPortSoap11">
		<soap:address location="http://localhost:8188/soapexample/ws"/>
	</wsdl:port>
</wsdl:service>
</wsdl:definitions>
```
