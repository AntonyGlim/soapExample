package glim.antony.soapexample;

import glim.antony.soapexample.util.GetUsersListRequest;
import glim.antony.soapexample.util.GetUsersListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CatalogEndpoint {
    private static final String AUTOGEN_NAMESPACE_URI = "http://www.soapexample.antony.glim/util";

    private SoapUsersService soapUsersService;

    @Autowired
    public void setSoapUsersService(SoapUsersService soapUsersService) {
        this.soapUsersService = soapUsersService;
    }

    @PayloadRoot(namespace = AUTOGEN_NAMESPACE_URI, localPart = "getUsersListRequest")
    @ResponsePayload
    public GetUsersListResponse getProductsListResponse(@RequestPayload GetUsersListRequest request) {
        GetUsersListResponse response = new GetUsersListResponse();
        response.setUsersList(soapUsersService.getAllUsers());
        return response;
    }
}
