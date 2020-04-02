document.querySelector('.chat[data-chat=person2]').classList.add('active-chat');
document.querySelector('.person[data-chat=person2]').classList.add('active');

var Id;

var friends = {
  list: document.querySelector('ul.people'),
  all: document.querySelectorAll('.left .person'),
  name: '',
  userId:''},

chat = {
  container: document.querySelector('.container .right'),
  current: null,
  person: null,
  receiveId: document.querySelector('.receiveId'),
  receiveIds: document.querySelector('.receiveIds'),
  name: document.querySelector('.container .right .top .name') };


friends.all.forEach(function (f) {
  f.addEventListener('mousedown', function () {
    f.classList.contains('active') || setAciveChat(f);
  });
});

function addChat() {
    alert(Id);
}

function setAciveChat(f) {
  friends.list.querySelector('.active').classList.remove('active');
  f.classList.add('active');
  chat.current = chat.container.querySelector('.active-chat');
  chat.person = f.getAttribute('data-chat');
  chat.current.classList.remove('active-chat');
  chat.container.querySelector('[data-chat="' + chat.person + '"]').classList.add('active-chat');
  friends.name = f.querySelector('.name').innerText;
  friends.userId = f.querySelector('.userId').value;
  chat.name.innerHTML = friends.name;
  chat.receiveId.value = friends.userId;
  chat.receiveIds.value = friends.userId;
  Id = friends.userId;
}