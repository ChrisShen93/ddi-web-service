package uk.ac.ebi.ddi.ws.util;

import uk.ac.ebi.ddi.ebe.ws.dao.utils.Constans;

/**
 * @author Yasset Perez-Riverol ypriverol
 */
public class Constants {

    public static final String ENTRY_COUNT              = "Number of entries";

    public static final String TAXONOMY_FIELD           = "TAXONOMY";

    public static final String MAIN_DOMAIN              = "omics";

    public static final String REPOSITORY_TAG           = "Repositories";

    public static final String TISSUE_FIELD             = "tissue" ;

    public static final String OMICS_TYPE_FIELD         = "omics_type";

    public static final String DISEASE_FIELD            = "disease";

    public static final String DESCRIPTION_FIELD        = "description";

    public static final String NAME_FIELD               = "name";

    public static final String SUBMITTER_KEY_FIELD      = "submitter_keywords";

    public static final String CURATOR_KEY_FIELD        = "curator_keywords";

    public static final String PUB_DATE_FIELD           = "publication_date";

    public static final String EGA_UPDATED_FIELD        = "updated";

    public static final String DATA_PROTOCOL_FIELD      = "data_protocol";

    public static final String SAMPLE_PROTOCOL_FIELD    = "sample_protocol";

    public static final String PUBMED_FIELD             = "PUBMED";

    public static final String DATASET_LINK_FIELD       = "full_dataset_link";

    public static final String INSTRUMENT_FIELD         = "instrument_platform";

    public static final String EXPERIMENT_TYPE_FIELD    = "technology_type";

    public static final String[] DATASET_SUMMARY        = {Constants.DESCRIPTION_FIELD,
                                                           Constants.NAME_FIELD,
                                                           Constants.SUBMITTER_KEY_FIELD,Constants.CURATOR_KEY_FIELD,
                                                           Constants.PUB_DATE_FIELD,
                                                           Constants.TAXONOMY_FIELD,
                                                           Constants.OMICS_TYPE_FIELD};


    public static final String[] DATASET_DETAIL         = {Constants.NAME_FIELD,
                                                           Constants.DESCRIPTION_FIELD,
                                                           Constants.PUB_DATE_FIELD,
                                                           Constants.DATASET_LINK_FIELD,
                                                           Constants.DATA_PROTOCOL_FIELD,
                                                           Constants.SAMPLE_PROTOCOL_FIELD,
                                                           Constants.INSTRUMENT_FIELD,
                                                           Constants.EXPERIMENT_TYPE_FIELD,
                                                           Constants.PUBMED_FIELD,
                                                           Constants.SUBMITTER_KEY_FIELD,Constants.CURATOR_KEY_FIELD,
                                                           Constants.TAXONOMY_FIELD,
                                                           Constants.DISEASE_FIELD,
                                                           Constants.OMICS_TYPE_FIELD,
                                                           Constants.TISSUE_FIELD};

    public static final String[] MORELIKE_FIELDS        =  {Constants.NAME_FIELD,
                                                            Constants.DESCRIPTION_FIELD,
                                                            Constants.DATA_PROTOCOL_FIELD,
                                                            Constants.SAMPLE_PROTOCOL_FIELD,
                                                            Constants.OMICS_TYPE_FIELD
    };



    public static final String  NOT_AVAILABLE           = "Not available";

    public static final String  NOT_APPLICABLE          = "not applicable";

    public static final String DATASET_FILE             = "dataset_file"  ;


    public static String TAXONOMY_NAME                  = "name";

    public static String[] TAXONOMY_FIELDS              = {Constants.TAXONOMY_NAME};

    public static String[] EXCLUSION_WORDS              = {"ega", "study","1","2","3","4","5","6","7","8","9","10","a","b","c","d","e","f","g","h",
            "i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
            "an", "and", "are", "as", "at", "be", "but", "by", "for", "if", "in", "into", "is", "it",
            "no", "not", "of", "on", "or", "such", "that", "the", "their", "then", "there", "these", "they", "this", "to", "was", "will", "with",
            "able","about","across","after","all","almost","also","am","among","an","and","any","are","as","at","be","because","been","can","could","dear","did",
            "do","does","either","else","ever","every","for","from","get","got","had","has","have","he","her","hers","him","how","however","i","in","into",
            "its","just","least","let","like","likely","may","me","might","most","must","neither","no","nor","not","of","off",
            "often","on","only","or","other","our","own","rather","should","since","so","some","than","that","the","their","them," +
            "then","there","these","they","this","tis","to","too","us","was","we","were","what","when","where","which","while",
            "who","whom","why","will","with","would","yet","you","your",
            "protein", "proteomics", "proteomic", "proteome", "proteomes", "mass", "proteins", "lc", "ms", "based", "from", "using", "during", "LC-MS", "LC-MS/MS","reveals","as","non","data"};

    public static String[] SHORT_EXCLUSION_WORDS              = {"ega", "study", "data", "using", "10", "available", "da", "two", "protein", "proteins", "peptide", "peptides", "20", "80", "24","30","50", "0", "100", "15", "24"};

    public static String TAXONOMY_DOMAIN               = "taxonomy";

    public static int HIGH_QUERY_THRESHOLD             = 100;

    public static String PRIDE_DOMAIN                  = "pride";

    public static String ORDER_ASCENDING               = "ascending";

    public static String ORDER_DESCENDING              = "descending";

    public static String PUBMED_AUTHOR_FIELD           = "author";

    public static String PUBMED_ABSTRACT_FIELD         = "description";

    public static String PUBMED_ID_FIELD               = "id";

    public static String PUBMED_ISSUE_FIELD            = "issue";

    public static String PUBMED_JOURNAL_FIELD          = "journal";

    public static String PUBMED_KEYS_FIELD             = "keywords";

    public static String PUBMED_NAME_FIELD             = "name";

    public static String PUBMED_PAG_FIELD              = "pagination";

    public static String PUBMED_VOL_FIELD              = "volume";

    public static String PUBMED_DATE_FIELD             = "publication_date";

    public static String PUBMED_AFFILATION_FIELD       = "affiliation";

    public static String[] PUBLICATION_SUMMARY         = { Constants.PUBMED_ABSTRACT_FIELD,
                                                           Constants.PUBMED_AUTHOR_FIELD,
                                                           Constants.PUBMED_DATE_FIELD,
                                                           Constants.PUBMED_ID_FIELD,
                                                           Constants.PUBMED_JOURNAL_FIELD,
                                                           Constants.PUBMED_ISSUE_FIELD,
                                                           Constants.PUBMED_KEYS_FIELD,
                                                           Constants.PUBMED_NAME_FIELD,
                                                           Constants.PUBMED_PAG_FIELD,
                                                           Constants.PUBMED_VOL_FIELD,
                                                           Constants.PUBMED_AFFILATION_FIELD
    };

    //Todo: We need to do this dynamic

    public static String[] INITIAL_DOMAINS            = { "omics"


    };


//    public static final String CHROMATOGRAPHY_PROTOCOL  = "chromatography_protocol";
//
//    public static final String MASS_SPEC_PROTOCOL       = "mass_spec_protocol";
//
//    public static final String METABOLITE_ID_PROTOCOL   = "metabolite_id_protocol";
//
//    public static final String NMR_ASSAY_PROTOCOL       = "nmr_assay_protocol";
//
//    public static final String NMR_SPEC_PROTOCOL        = "nmr_spec_protocol";

//    public static final String DERIVATIZATION_PROTOCOL  = "derivatization_protocol";
//
//    public static final String EXTRACTION_PROTOCOL      = "extraction_protocol";

}
