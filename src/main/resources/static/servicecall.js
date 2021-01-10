function submitRequest() {
    var data = JSON.stringify(
        [{
            "name": "gold",
            "count": document.getElementById("gold").value
        },
            {
                "name": "art",
                "count": document.getElementById("art").value
            },
            {
                "name": "wd",
                "count": document.getElementById("wd").value
            },
            {
                "name": "cash",
                "count": document.getElementById("cash").value
            },
            {
                "name": "ck",
                "count": document.getElementById("ck").value
            }
        ]);
    var n = document.getElementById("playersCount").value;
    console.log(n);
    console.log(data);
    var xhr = new XMLHttpRequest();
    xhr.withCredentials = true;

    xhr.addEventListener("readystatechange", function () {
        if (this.readyState === 4 && this.status == 200) {
            var apiResponse = JSON.parse(this.responseText);
            populateOutput(apiResponse)
        }
    });
    xhr.open("POST", "https://knapsack-problem-app.herokuapp.com/knapsack?players=" + n);
   // xhr.open("GET", "dummyresponse.json");
    xhr.setRequestHeader("Content-Type", "application/json");

    xhr.send(data);
}

function populateOutput(apiResponse) {
    var table = document.getElementById("output-table");
    table.style.visibility = "visible";
    clearTableData(table);
    var itemList = apiResponse.itemList;

    var currencyFormat = new Intl.NumberFormat('en', {
        style: 'currency',
        currency: 'USD',
        minimumFractionDigits: 2,
    });
    for (i = 0; i < apiResponse.itemList.length; i++) {
        var newRow = table.insertRow(i + 1);
        var itemCell = newRow.insertCell(0);
        var countCell = newRow.insertCell(1);

        itemCell.appendChild(document.createTextNode(itemList[i].name.toUpperCase()));
        itemCell.style.color="lawngreen";
        countCell.appendChild(document.createTextNode(itemList[i].count));
        countCell.style.color="lawngreen";
    }
    var finalRow = table.insertRow();
    finalRow.className = "success";
    finalRow.insertCell(0).appendChild(document.createTextNode("MAX PROFIT"));
    finalRow.insertCell(1).appendChild(document.createTextNode(
        currencyFormat.format(apiResponse.maxProfit)));
}

function clearTableData(table) {
    var len = table.rows.length;
    while (len-- > 1){
        if(table.rows[len].id !== 'thead-output')
            table.deleteRow(len);
    }
}
