//글 등록 기능
const createButton = document.getElementById('create-btn');
// event click이 감지되면 등록 API 요청
if(createButton){
    createButton.addEventListener('click', event => {
        fetch("/api/articles", {
            method: 'POST',
            header: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title: document.getElementById('title').value,
                content: document.getElementById('content').value,
            }),
        })
            .then(() => {
                alert("등록이 완료되었습니다.")
                location.replace('/articles');
            })
    })
}
//글 삭제 기능
const deleteButton = document.getElementById('delete-btn');
// event click이 감지되면 삭제 API 요청
if(deleteButton){
    deleteButton.addEventListener('click', event => {
        let id = document.getElementById('article-id').value;
        fetch(`/api/articles/${id}`, {
            method: 'DELETE'
        })
            .then(() => {
                alert('삭제가 완료되었습니다.');
                location.replace('/articles');
        });
    });
}

//글 수정기능
const modifyButton = document.getElementById('modify-btn');
// event click이 감지되면 수정 API 요청
if(modifyButton){
    modifyButton.addEventListener('click', event => {
        let params = new URLSearchParams(location.search);
        let id = params.get('id');

        fetch(`/api/articles/${id}`, {
            method: 'PUT',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                //수정한 title, content를 json 형식으로 변경해서 보낸다.
                title: document.getElementById('title').value,
                content: document.getElementById('content').value
            })
        })
            .then(() => {
                alert("수정이 왼료되었습니다.");
                location.replace(`/articles/${id}`);
            });
    });
}