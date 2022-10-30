* @ValidationCode : MjotMTAxNDY0NDc5MzpDcDEyNTI6MTY1OTUwMzkyOTUwNTpEUzAwODQzODU2Oi0xOi0xOjA6MDpmYWxzZTpOL0E6UjIxX1NQMTMuMDotMTotMQ==
* @ValidationInfo : Timestamp         : 03 Aug 2022 10:48:49
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
PROGRAM TWODIM.ARRAY.2
*-----------------------------------------------------------------------------
*
*-----------------------------------------------------------------------------
* Modification History :
*-----------------------------------------------------------------------------

*-----------------------------------------------------------------------------
    DIM ARR(4,3)
    FOR I.CTR=1 TO 4
        FOR J.CTR= 1 TO 3
            INPUT KK
            ARR(I.CTR,J.CTR)=KK
        NEXT J.CTR
    NEXT I.CTR
    FOR K.CTR=1 TO 4
        FOR L.CTR=1 TO 3
            PRINT"VALUE IS :" :ARR(K.CTR,L.CTR)
        NEXT L.CTR
    NEXT K.CTR
END
END
