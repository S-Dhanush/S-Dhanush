* @ValidationCode : MjoxMzE4MzI5NDk2OkNwMTI1MjoxNjU5NTAzODQwODczOkRTMDA4NDM4NTY6LTE6LTE6MDowOmZhbHNlOk4vQTpSMjFfU1AxMy4wOi0xOi0x
* @ValidationInfo : Timestamp         : 03 Aug 2022 10:47:20
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
PROGRAM TWODIM.ARRAY
*-----------------------------------------------------------------------------
*
*-----------------------------------------------------------------------------
* Modification History :
*-----------------------------------------------------------------------------

*-----------------------------------------------------------------------------
    DIM ARR(3,2)
    FOR I.CTR=1 TO 3
        FOR J.CTR= 1 TO 2
            INPUT KK
            ARR(I.CTR,J.CTR)=KK
        NEXT J.CTR
    NEXT I.CTR
    FOR K.CTR=1 TO 3
        FOR L.CTR=1 TO 2
            PRINT"VALUE IS :" :ARR(K.CTR,L.CTR)
        NEXT L.CTR
    NEXT K.CTR
END
