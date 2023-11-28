var factPlaceholder = document.getElementById("char-fact");
var showFact = document.getElementById("show-fact");


var CharFacts = ["The founding members of helping hand are Alex, Ayan, Maria, Jack, Shaq, Azim, Usama & Nima.",
    "There are 760,000 paid employees in the charity sector.",
    "Both men(52 %) and women(54 %) prefer to donate money using credit and debit cards.",
    "Nearly one - third of contributors worldwide give money to charities and nonprofits outside their country. Approximately 31 % of people donate to countries other than their own",
    "The top five countries that receive money from foreigners are the United States(17 %), Israel(8 %), Canada(7 %), Syria(5 %), and India(4 %)..",
    "Research finds 8 out of 10 people donate after being asked.",
    "Motivations to give: In a survey 59 % said it was a cause they believed in, 37 % said supporting charities is a good thing to do and 21 %: the charity had helped someone they know.",
    "Less than 70% of all money raised goes to charity. The perecentage of donations that actually go to charity is about 67, according to fundraises statistics from 2017. The rest goes to fundraising costs",
    "In the UK, people donate the most money to medical reseach(26%) and animal welfare(24%). Religious organizations however get the most in contributions by monetary value (NPT UK)",
    "Helping hand was established in 2021."]

var factNumber;

function randomFact() {
    return CharFacts[factNumber];
}
showFact.addEventListener('click', function () {
    factNumber = Math.floor(Math.random() * 10);
    factPlaceholder.textContent = randomFact();
});


// showFact.addEventListener('click', function () {
//     for (var i = 0; i < CharFacts.length(); i++) {
//         factNumber = i;
//         factPlaceholder.textContent = randomFact();
//     }


//     // factNumber = Math.floor(Math.random() * 10);

// });




// var randomNumber;
// for (var l = 0; l < 10; l++) {
//     do {
//         randomNumber = Math.floor(Math.random() * 10);
//     } while ();

// }











// do {
//     random = Math.floor(Math.random() * (max - min)) + min;
// } while (random === getNumber.last);
// getNumber.last = random;
// return random;
// };

