PROGRAM FILEREAD
*-----------------------------------------------------------------------------
*
*-----------------------------------------------------------------------------
* Modification History :
*-----------------------------------------------------------------------------

*-----------------------------------------------------------------------------



    $INSERT I_COMMON
    $INSERT I_EQUATE
    $INSERT I_F.ACCOUNT




    FN.ACC= "FBNK.ACCOUNT"
    F.ACC = " "



    CALL OPF(FN.ACC,F.ACC)
    SEL.CMD = "SELECT " : FN.ACC
    CALL EB.READLIST(SEL.CMD,ACC.LIST,"",NO.OF.ACC,ERR.CODE)



    FOR I.CTR = 1 TO NO.OF.ACC
        Y.ACC.ID = ACC.LIST<I.CTR>
        CALL F.READ(FN.ACC,Y.ACC.ID,R.ACCOUNT,F.ACC,ERR)
        Y.CUSTOMER = R.ACCOUNT<AC.CUSTOMER>
        Y.CATEGORY = R.ACCOUNT<AC.CATEGORY>
        Y.CURRENCY = R.ACCOUNT<AC.CURRENCY>


        PRINT "THE CUSTOMER ID IS:" : Y.CUSTOMER
        PRINT "THE CATEGORY IS:" : Y.CATEGORY
        PRINT "THE CURRENCY IS:" : Y.CURRENCY



    NEXT I.CTR
END
END
