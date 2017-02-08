package org.wuxinshui.boosters.test.json;

import org.wuxinshui.boosters.json.JSONUtils;
import org.junit.Test;

import java.text.DateFormat;
import java.util.Calendar;

/**
 * Created by FujiRen on 2016/5/5.
 */
public class JSONUtilsTest {

    @Test
    public void test1() {
        String jsonStr = "{\"AAARRANGEMENTACTIVITYITF\":{\"AAARRANGEMENTACTIVITYITFType\":{\"ARRANGEMENT\":\"\",\"ACTIVITY\":\"\",\"EFFECTIVEDATE\":\"\",\"CUSTOMER\":\"\",\"PRODUCT\":\"\",\"CURRENCY\":\"\",\"ARRCOMPANYCODE\":\"\",\"LINKEDACTIVITY\":\"\",\"ORIGCONTRACTDATE\":\"\",\"EXPOSUREDATE\":\"\",\"PROPERTY\":[{\"ACCOUNT\":[{\"L_DOT_FX_DOT_FT_DOT_REV_DOT_FLG\":\"\",\"L_DOT_RENEW_DOT_LST_DOT_AD_DOT_ID\":\"\",\"L_DOT_COLL_DOT_PLAN_DOT_NO\":\"\",\"L_DOT_FX_DOT_FT_DOT_REV_DOT_AMT\":\"\",\"L_DOT_PRFT_DOT_PAY_DOT_FLG\":\"\",\"L_DOT_PART_DOT_RDM_DOT_AMT\":\"\",\"L_DOT_DAO\":\"\",\"L_DOT_RENEW_DOT_NEW_DOT_PRD_DOT_ID\":\"\",\"L_DOT_RENEW_DOT_ORG_DOT_AD_DOT_ID\":\"\",\"L_DOT_AD_DOT_AL_DOT_MAPPING_DOT_FLAG\":\"\",\"L_DOT_RENEW_DOT_FLG\":\"\",\"L_DOT_CLS_DOT_DATE\":\"\",\"L_DOT_FUND_DOT_PAY_DOT_WAY\":\"\",\"L_DOT_CD_DOT_AC_DOT_PHONE\":\"\",\"L_DOT_INT_DOT_TYPE\":\"\",\"L_DOT_CD_DOT_AC_DOT_ID\":\"\",\"ACCOUNT_DOT_TITLE_DOT_2\":\"\",\"ACCOUNT_DOT_TITLE_DOT_1\":\"\",\"L_DOT_CD_DOT_AC_DOT_OPENING_DOT_BANK\":\"\",\"L_DOT_ARR_DOT_REV_DOT_FLG\":\"\",\"L_DOT_URGENT_DOT_CLS_DOT_FLG\":\"\",\"L_DOT_DIR_DOT_INV_DOT_FLG\":\"\",\"L_DOT_IN_DOT_DELAY_DOT_PAY_DOT_FLG\":\"\",\"L_DOT_CHANNEL_DOT_ID\":\"\",\"MNEMONIC\":\"\",\"L_DOT_TERM_DOT_TYPE\":\"\",\"L_DOT_PRMT_DOT_CODE\":\"\",\"L_DOT_WM_DOT_TRUST_DOT_STATUS\":\"\",\"L_DOT_CD_DOT_AC_DOT_OPENING_DOT_BANK_DOT_P\":\"\",\"L_DOT_LINEAR_DOT_STOP_DOT_FLAG\":\"\",\"L_DOT_PART_DOT_RDM_DOT_FLAG\":\"\",\"L_DOT_CD_DOT_AC_DOT_TITLE\":\"\",\"L_DOT_PR_DOT_INT_DOT_REV_DOT_FLG\":\"\",\"L_DOT_PAYOFF_DOT_DAYS\":\"\",\"L_DOT_IMAGE_DOT_LINK\":\"\",\"L_DOT_PR_DOT_DELAY_DOT_PAY_DOT_FLG\":\"\",\"L_DOT_CD_DOT_AC_DOT_OPENING_DOT_BANK_DOT_C\":\"\",\"L_DOT_RENEW_DOT_NEW_DOT_AD_DOT_ID\":\"\",\"L_DOT_PR_DOT_INT_DOT_REV_DOT_AMT\":\"\",\"L_DOT_CLS_DOT_FLG\":\"\",\"ALT_DOT_ID_DOT_TYPE_SUB_2\":\"\",\"ALT_DOT_ID_SUB_2\":\"\",\"ALT_DOT_ID_DOT_TYPE_SUB_1\":\"\",\"ALT_DOT_ID_SUB_1\":\"\",\"SHORT_DOT_TITLE\":\"\",\"L_DOT_LINEAR_DOT_STOP_DOT_DATE\":\"\",\"L_DOT_PART_DOT_RDM_DOT_DATE\":\"\",\"L_DOT_CD_DOT_AC_DOT_TYPE\":\"\"}],\"EFFECTIVE\":\"\"},{\"COMMITMENT\":[{\"MATURITY_DOT_DATE\":\"\",\"L_DOT_INV_DOT_CLS_DOT_DATE\":\"\",\"L_DOT_INV_DOT_CLS_DOT_TERM\":\"\",\"AMOUNT\":\"\",\"TERM\":\"\"}],\"EFFECTIVE\":\"\"},{\"DEPOSITINT\":[{\"L_DOT_MIN_DOT_RATE\":\"\",\"FIXED_DOT_RATE_SUB_1\":\"\",\"L_DOT_MAX_DOT_RATE\":\"\"}],\"EFFECTIVE\":\"\"},{\"SETTLEMENT\":[{\"PAYIN_DOT_SETTLEMENT_SUB_1\":\"\",\"PAYMENT_DOT_TYPE_SUB_1_DOT_1\":\"\",\"PAYIN_DOT_ACTIVITY_SUB_1_DOT_1\":\"\",\"PAYIN_DOT_ACCOUNT_SUB_1_DOT_1\":\"\",\"PAYIN_DOT_SETTLE_DOT_ACTIVITY_SUB_1\":\"\",\"PAYIN_DOT_AC_DOT_DB_DOT_RULE_SUB_1\":\"\"}],\"EFFECTIVE\":\"\"},{\"SCHEDULE\":[{\"PROPERTY_SUB_1_DOT_1\":\"\",\"DUE_DOT_FREQUENCY\":\"\",\"PAYMENT_DOT_TYPE_SUB_1_DOT_1\":\"\",\"PAYMENT_DOT_METHOD_SUB_1_DOT_1\":\"\",\"ACTUAL_DOT_AMOUNT_SUB_1_DOT_1\":\"\",\"PAYMENT_DOT_FREQ_SUB_1_DOT_1\":\"\",\"START_DOT_DATE_SUB_1_DOT_1\":\"\"}],\"EFFECTIVE\":\"\"}],\"NARRATIVE\":[{\"NARRATIVE\":\"\"}],\"EXTEVENTREF\":\"\",\"@id\":\"\"}}}";
        System.out.println(JSONUtils.parseDotSub(jsonStr));
    }

    @Test
    public void test2() {
        String jsonStr = "{\"AAARRANGEMENTACTIVITYITF\":{\"AAARRANGEMENTACTIVITYITFType\":{\"ARRANGEMENT\":\"\",\"ACTIVITY\":\"\",\"EFFECTIVEDATE\":\"\",\"CUSTOMER\":\"\",\"PRODUCT\":\"\",\"CURRENCY\":\"\",\"ARRCOMPANYCODE\":\"\",\"LINKEDACTIVITY\":\"\",\"ORIGCONTRACTDATE\":\"\",\"EXPOSUREDATE\":\"\",\"PROPERTY\":[{\"ACCOUNT\":[{\"L_DOT_FX_DOT_FT_DOT_REV_DOT_FLG\":\"\",\"L_DOT_RENEW_DOT_LST_DOT_AD_DOT_ID\":\"\",\"L_DOT_COLL_DOT_PLAN_DOT_NO\":\"\",\"L_DOT_FX_DOT_FT_DOT_REV_DOT_AMT\":\"\",\"L_DOT_PRFT_DOT_PAY_DOT_FLG\":\"\",\"L_DOT_PART_DOT_RDM_DOT_AMT\":\"\",\"L_DOT_DAO\":\"\",\"L_DOT_RENEW_DOT_NEW_DOT_PRD_DOT_ID\":\"\",\"L_DOT_RENEW_DOT_ORG_DOT_AD_DOT_ID\":\"\",\"L_DOT_AD_DOT_AL_DOT_MAPPING_DOT_FLAG\":\"\",\"L_DOT_RENEW_DOT_FLG\":\"\",\"L_DOT_CLS_DOT_DATE\":\"\",\"L_DOT_FUND_DOT_PAY_DOT_WAY\":\"\",\"L_DOT_CD_DOT_AC_DOT_PHONE\":\"\",\"L_DOT_INT_DOT_TYPE\":\"\",\"L_DOT_CD_DOT_AC_DOT_ID\":\"\",\"ACCOUNT_DOT_TITLE_DOT_2\":\"\",\"ACCOUNT_DOT_TITLE_DOT_1\":\"\",\"L_DOT_CD_DOT_AC_DOT_OPENING_DOT_BANK\":\"\",\"L_DOT_ARR_DOT_REV_DOT_FLG\":\"\",\"L_DOT_URGENT_DOT_CLS_DOT_FLG\":\"\",\"L_DOT_DIR_DOT_INV_DOT_FLG\":\"\",\"L_DOT_IN_DOT_DELAY_DOT_PAY_DOT_FLG\":\"\",\"L_DOT_CHANNEL_DOT_ID\":\"\",\"MNEMONIC\":\"\",\"L_DOT_TERM_DOT_TYPE\":\"\",\"L_DOT_PRMT_DOT_CODE\":\"\",\"L_DOT_WM_DOT_TRUST_DOT_STATUS\":\"\",\"L_DOT_CD_DOT_AC_DOT_OPENING_DOT_BANK_DOT_P\":\"\",\"L_DOT_LINEAR_DOT_STOP_DOT_FLAG\":\"\",\"L_DOT_PART_DOT_RDM_DOT_FLAG\":\"\",\"L_DOT_CD_DOT_AC_DOT_TITLE\":\"\",\"L_DOT_PR_DOT_INT_DOT_REV_DOT_FLG\":\"\",\"L_DOT_PAYOFF_DOT_DAYS\":\"\",\"L_DOT_IMAGE_DOT_LINK\":\"\",\"L_DOT_PR_DOT_DELAY_DOT_PAY_DOT_FLG\":\"\",\"L_DOT_CD_DOT_AC_DOT_OPENING_DOT_BANK_DOT_C\":\"\",\"L_DOT_RENEW_DOT_NEW_DOT_AD_DOT_ID\":\"\",\"L_DOT_PR_DOT_INT_DOT_REV_DOT_AMT\":\"\",\"L_DOT_CLS_DOT_FLG\":\"\",\"ALT_DOT_ID_DOT_TYPE_SUB_2\":\"\",\"ALT_DOT_ID_SUB_2\":\"\",\"ALT_DOT_ID_DOT_TYPE_SUB_1\":\"\",\"ALT_DOT_ID_SUB_1\":\"\",\"SHORT_DOT_TITLE\":\"\",\"L_DOT_LINEAR_DOT_STOP_DOT_DATE\":\"\",\"L_DOT_PART_DOT_RDM_DOT_DATE\":\"\",\"L_DOT_CD_DOT_AC_DOT_TYPE\":\"\"}],\"EFFECTIVE\":\"\"},{\"COMMITMENT\":[{\"MATURITY_DOT_DATE\":\"\",\"L_DOT_INV_DOT_CLS_DOT_DATE\":\"\",\"L_DOT_INV_DOT_CLS_DOT_TERM\":\"\",\"AMOUNT\":\"\",\"TERM\":\"\"}],\"EFFECTIVE\":\"\"},{\"DEPOSITINT\":[{\"L_DOT_MIN_DOT_RATE\":\"\",\"FIXED_DOT_RATE_SUB_1\":\"\",\"L_DOT_MAX_DOT_RATE\":\"\"}],\"EFFECTIVE\":\"\"},{\"SETTLEMENT\":[{\"PAYIN_DOT_SETTLEMENT_SUB_1\":\"\",\"PAYMENT_DOT_TYPE_SUB_1_DOT_1\":\"\",\"PAYIN_DOT_ACTIVITY_SUB_1_DOT_1\":\"\",\"PAYIN_DOT_ACCOUNT_SUB_1_DOT_1\":\"\",\"PAYIN_DOT_SETTLE_DOT_ACTIVITY_SUB_1\":\"\",\"PAYIN_DOT_AC_DOT_DB_DOT_RULE_SUB_1\":\"\"}],\"EFFECTIVE\":\"\"},{\"SCHEDULE\":[{\"PROPERTY_SUB_1_DOT_1\":\"\",\"DUE_DOT_FREQUENCY\":\"\",\"PAYMENT_DOT_TYPE_SUB_1_DOT_1\":\"\",\"PAYMENT_DOT_METHOD_SUB_1_DOT_1\":\"\",\"ACTUAL_DOT_AMOUNT_SUB_1_DOT_1\":\"\",\"PAYMENT_DOT_FREQ_SUB_1_DOT_1\":\"\",\"START_DOT_DATE_SUB_1_DOT_1\":\"\"}],\"EFFECTIVE\":\"\"}],\"NARRATIVE\":[{\"NARRATIVE\":\"\"}],\"EXTEVENTREF\":\"\",\"@id\":\"\"}}}";
        jsonStr = JSONUtils.parseDotSub(jsonStr);
//        System.out.println(JSONUtils.parseToColon(jsonStr));
//        String str="C.ab:1.2.3";
        String str = "\"PAYMENT.METHOD-1.1\": \"\"";
        System.out.println(JSONUtils.parseToColon(str));
    }

    @Test
    public void testGetJSONXpath() {
        String s="";

        System.out.println(JSONUtils.getJSONXpath(s));
    }


    @Test
    public void testTime(){
        Calendar.getInstance().getTime();
        System.out.println(Calendar.getInstance().getTime());
        System.out.println( DateFormat.getInstance().format(Calendar.getInstance().getTime()));
    }
}
