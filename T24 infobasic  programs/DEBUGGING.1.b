* @ValidationCode : Mjo5MTkyNzE5MDc6Q3AxMjUyOjE2NTk1ODg3Nzc4NzI6RFMwMDg0Mzg1NjotMTotMTowOjA6ZmFsc2U6Ti9BOlIyMV9TUDEzLjA6LTE6LTE=
* @ValidationInfo : Timestamp         : 04 Aug 2022 10:22:57
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
PROGRAM DEBUGGING.1
*-----------------------------------------------------------------------------
*
*-----------------------------------------------------------------------------
* Modification History :
*-----------------------------------------------------------------------------

*-----------------------------------------------------------------------------
    PRINT "HELLO WORLD"
    GOSUB INITIALIZE;
*OPEN FILES ETC...
    GOSUB MAIN;
*PERFORM MAIN PROGRAM
    GOSUB FINISH;
*CLOSE FILES ETC..
    STOP

INITIALIZE:
*OPEN FILES
    PRINT "OPEN"
    KAVI=6
    DHAKSHAN=1
    SAM=2
    LOK=4

RETURN

MAIN:
*MAIN EXECUTION LOOP
    PRINT "MAIN"
    MAHESH = SAM + LOK
    DHANUSH = MAHESH * KAVI
RETURN

FINISH:
*CLEAN UP AFTER EXECUTION
    PRINT "MAHESH VAL IS:" : MAHESH
    PRINT "DHANUSH VAL IS:" : DHANUSH
    PRINT "FINISH"
RETURN
END
END
