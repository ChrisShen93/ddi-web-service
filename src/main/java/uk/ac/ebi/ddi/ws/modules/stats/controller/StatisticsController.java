package uk.ac.ebi.ddi.ws.modules.stats.controller;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import uk.ac.ebi.ddi.ebe.ws.dao.client.domain.DomainWsClient;
import uk.ac.ebi.ddi.ebe.ws.dao.client.facet.FacetWsClient;
import uk.ac.ebi.ddi.ebe.ws.dao.model.domain.DomainList;
import uk.ac.ebi.ddi.ebe.ws.dao.model.facet.FacetList;
import uk.ac.ebi.ddi.ws.modules.stats.model.DomainStats;
import uk.ac.ebi.ddi.ws.modules.stats.model.StatRecord;
import uk.ac.ebi.ddi.ws.modules.stats.util.RepoStatsToWsStatsMapper;
import uk.ac.ebi.ddi.ws.util.Constants;
import uk.ac.ebi.ddi.ws.util.WsUtilities;


import java.util.List;

/**
 * Controller for accessing the statistics
 *
 * @author ypriverol Yasset Perez-Riverol
 */

@Api(value = "stats", description = "retrieve statistics about the DDI repositories, access, etc", position = 0)
@Controller
@RequestMapping(value = "/stats")

public class StatisticsController {

    private static final Logger logger = LoggerFactory.getLogger(StatisticsController.class);

    @Autowired
    DomainWsClient domainWsClient;

    @Autowired
    FacetWsClient facetWsClient;

    @ApiOperation(value = "Return statistics about the number of datasets per Repository", position = 1, notes = "Return statistics about the number of datasets per Repository")
    @RequestMapping(value = "/domains", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK) // 200
    public @ResponseBody
    List<DomainStats> getDomainEntries() {

        DomainList domain = domainWsClient.getDomainByName(Constants.MAIN_DOMAIN);

        return RepoStatsToWsStatsMapper.asDomainStatsList(domain);
    }

    @ApiOperation(value = "Return statistics about the number of datasets per Organisms", position = 1, notes = "Return statistics about the number of datasets per Organisms")
    @RequestMapping(value = "/organisms", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK) // 200
    public @ResponseBody
    List<StatRecord> getTaxonomies() {

        DomainList domain    = domainWsClient.getDomainByName(Constants.MAIN_DOMAIN);

        String[] dubdomains  = WsUtilities.getSubdomainList(Constants.MAIN_DOMAIN, domain);

        FacetList taxonomies = facetWsClient.getFacetEntriesByDomains(Constants.MAIN_DOMAIN,dubdomains,Constants.TAXONOMY_FIELD, 20);

        return RepoStatsToWsStatsMapper.asFacetCount(taxonomies, Constants.TAXONOMY_FIELD);
    }

    @ApiOperation(value = "Return statistics about the number of datasets per Tissue", position = 1, notes = "Return statistics about the number of datasets per Tissue")
     @RequestMapping(value = "/tissues", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
     @ResponseStatus(HttpStatus.OK) // 200
     public @ResponseBody
     List<StatRecord> getTissues() {

        DomainList domain    = domainWsClient.getDomainByName(Constants.MAIN_DOMAIN);

        String[] dubdomains  = WsUtilities.getSubdomainList(Constants.MAIN_DOMAIN, domain);

        FacetList tissues = facetWsClient.getFacetEntriesByDomains(Constants.MAIN_DOMAIN,dubdomains,Constants.TISSUE_FIELD, 20);

        return RepoStatsToWsStatsMapper.asFacetCount(tissues, Constants.TISSUE_FIELD);
    }

     @ApiOperation(value = "Return statistics about the number of datasets per Omics Type", position = 1, notes = "Return statistics about the number of datasets per Omics Type")
     @RequestMapping(value = "/omicsType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
     @ResponseStatus(HttpStatus.OK) // 200
     public @ResponseBody
     List<StatRecord> getOmics() {

        DomainList domain    = domainWsClient.getDomainByName(Constants.MAIN_DOMAIN);

        String[] dubdomains  = WsUtilities.getSubdomainList(Constants.MAIN_DOMAIN, domain);

        FacetList tissues = facetWsClient.getFacetEntriesByDomains(Constants.MAIN_DOMAIN,dubdomains,Constants.OMICS_TYPE_FIELD, 20);

        return RepoStatsToWsStatsMapper.asFacetCount(tissues, Constants.OMICS_TYPE_FIELD);
    }

    @ApiOperation(value = "Return statistics about the number of datasets per dieases", position = 1, notes = "Return statistics about the number of datasets per diseases")
    @RequestMapping(value = "/diseases", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK) // 200
    public @ResponseBody
    List<StatRecord> getDiseases() {

        DomainList domain    = domainWsClient.getDomainByName(Constants.MAIN_DOMAIN);

        String[] dubdomains  = WsUtilities.getSubdomainList(Constants.MAIN_DOMAIN, domain);

        FacetList tissues = facetWsClient.getFacetEntriesByDomains(Constants.MAIN_DOMAIN,dubdomains,Constants.DISEASE_FIELD, 20);

        return RepoStatsToWsStatsMapper.asFacetCount(tissues, Constants.DISEASE_FIELD);
    }


}
