* @ValidationCode : MjotMTQ1ODc3MzY2MTpDcDEyNTI6MTY1OTMzOTczMTU2ODpEUzAwODQzODU2Oi0xOi0xOjA6MDpmYWxzZTpOL0E6UjIxX1NQMTMuMDotMTotMQ==
* @ValidationInfo : Timestamp         : 01 Aug 2022 13:12:11
* @ValidationInfo : Encoding          : Cp1252
* @ValidationInfo : User Name         : DS00843856
* @ValidationInfo : Nb tests success  : N/A
* @ValidationInfo : Nb tests failure  : N/A
* @ValidationInfo : Rating            : N/A
* @ValidationInfo : Coverage          : N/A
* @ValidationInfo : Strict flag       : N/A
* @ValidationInfo : Bypass GateKeeper : false
* @ValidationInfo : Compiler Version  : R21_SP13.0
* @ValidationInfo : Copyright Temenos Headquarters SA 1993-2021. All rights reserved.
PROGRAM NESTED.IF.ELSE
*-----------------------------------------------------------------------------
*
*-----------------------------------------------------------------------------
* Modification History :
*-----------------------------------------------------------------------------

*-----------------------------------------------------------------------------
    CRT'ENTER A NUMBER'
    INPUT DA
    IF DA > 100 THEN
        PRINT"THE NUMBER IS GREATER THAN 100"
    END ELSE
        IF DA > 50 THEN
            PRINT"NUMBER IS GREATER THAN 50 BUT LESSER THAN 100"
        END ELSE
            PRINT"NUMBER IS LESS THAN 50"
        END
    END
END
