package uk.gov.api.springboot.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.gov.api.models.metadata.ApiMetadata;
import uk.gov.api.models.metadata.BulkMetadataResponse;
import uk.gov.api.springboot.services.MetadataService;

@RestController
@RequestMapping("/apis")
public class MetadataController {

  private final MetadataService service;

  public MetadataController(MetadataService service) {
    this.service = service;
  }

  @GetMapping(produces = "application/vnd.uk.gov.api.v1alpha+json")
  public BulkMetadataResponse retrieveAll() {
    List<ApiMetadata> apiMetadata = service.retrieveAll();
    var response = new BulkMetadataResponse();
    response.setApis(apiMetadata);
    response.setApiVersion(BulkMetadataResponse.ApiVersion.API_GOV_UK_V_1_ALPHA);
    return response;
  }
}
