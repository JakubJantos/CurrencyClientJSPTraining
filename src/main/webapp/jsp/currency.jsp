<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <style>
        body {
            margin: 0px;
            background-image: url("https://ewscripps.brightspotcdn.com/dims4/default/5857dc5/2147483647/strip/true/crop/640x360+0+60/resize/1280x720!/quality/90/?url=https%3A%2F%2Fewscripps.brightspotcdn.com%2F81%2F9a%2Fd75339db4387870d5ea567eeae48%2Fcash-money.jpg");
            background-size: cover;
            overflow: hidden;
        }

        .wrapper {
            margin: 0px auto;
            padding: 20px;
            width: 100%;
            background-color: rgba(0, 0, 0, 0.6);
            margin-top: 0px;
        }

        .form-wrap {
            margin: 0px auto;
            width: 50%;
            padding: 20px;
            border: 2px solid royalblue;
            border-radius: 10px;
            background-color: cadetblue;
            font-family: Arial;
            font-size: 20px;
        }

        .result-wrap {
            width: 50%;
            padding: 20px;
            margin: 0px auto;
            background-color: cadetblue;
            border-radius: 10px;
            border: 2px solid royalblue;
            margin-top: 30px;
        }

        .symbol {
            padding: 10px;
            background-color: lightgreen;
            display: inline-block;
            width: 70px;
            margin-top: 5px;
        }

        .value {
            padding: 10px;
            background-color: lightseagreen;
            display: inline-block;
            width: 70px;
            margin-top: 5px;
        }

        .title {
            background-color: rgba(0, 0, 0, 0.6);
            width: 100%;
            color: #fff;
            font-family: Arial;
            margin-bottom: 100px;
            margin-top: 100px;
            padding: 20px;
            text-align: center;
        }

    </style>
</head>
<body>
<div class="title">
    <h1>KANTOR</h1>
</div>
<div class="wrapper">
    <div class="form-wrap">
        <form method="post" action="/currency">
            <label>Data notowań</label>
            <input type="date" name="exchangeDate" value="${selectetDate}"/>
            <input type="submit"/>
            <br/>
            <label>Waluta bazowa</label>
            <select name="selectedBase">
                <option
                        <c:if test="${prevSel eq 'EUR'}">
                            selected
                        </c:if> >
                    EUR
                </option>
                <option
                        <c:if test="${prevSel eq 'PLN'}">
                            selected
                        </c:if> >
                    PLN
                </option>
                <option
                        <c:if test="${prevSel eq 'USD'}">
                            selected
                        </c:if> >
                    USD
                </option>
                <option
                        <c:if test="${prevSel eq 'GBP'}">
                            selected
                        </c:if> >
                    GBP
                </option>

            </select>
        </form>
    </div>

    <c:if test="${currenciesRates != null}">
        <div class="result-wrap">
            <c:forEach items="${currenciesRates.rates}" var="rate">
                <div>
                    <span class="symbol">${rate.key}</span>
                    <span class="value"><fmt:formatNumber value="${rate.value}" maxFractionDigits="2"
                                                          type="number"/> </span>
                </div>
            </c:forEach>

        </div>
    </c:if>
</div>
</body>
</html>